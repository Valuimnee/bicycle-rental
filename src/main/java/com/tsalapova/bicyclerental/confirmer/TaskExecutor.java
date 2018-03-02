package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConfirmerException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class TaskExecutor {
    private static TaskExecutor instance = new TaskExecutor();

    private static final int POOL_SIZE = 20;

    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(POOL_SIZE);
    private HashMap<Long, ScheduledFuture<?>> tasks;

    public static TaskExecutor getInstance() {
        return instance;
    }

    private TaskExecutor() {
        executor.setRemoveOnCancelPolicy(true);
        tasks = new HashMap<>();
    }

    public HashMap<Long, ScheduledFuture<?>> getTasks() {
        return tasks;
    }

    public void setupInitialRentals() {
        List<Rental> rentals;
        try {
            rentals = new RentalLogicImpl().findConcluded();
        } catch (LogicException e) {
            throw new ConfirmerException("Error occurred when setting up task holder", e);
        }
        for (Rental rental : rentals) {
            addTask(new RentalConfirmationTask(rental));
        }
    }

    public void addTask(RentalConfirmationTask task) {
        long delay = Duration.between(LocalDateTime.now(), task.getLocalDateTime()).toMinutes();
        if (delay < 0L) {
            delay = 0L;
        }
        ScheduledFuture<?> future = executor.schedule(task, delay, TimeUnit.MINUTES);
        tasks.put(task.getRentalId(), future);
    }

    public void removeTask(long rentalId) {
        ScheduledFuture<?> future = tasks.get(rentalId);
        future.cancel(false);
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}
