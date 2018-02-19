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
public class RentalConfirmer {
    private static RentalConfirmer instance = new RentalConfirmer();

    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(20);
    private HashMap<Long, ScheduledFuture<?>> tasks;

    public static RentalConfirmer getInstance() {
        return instance;
    }

    private RentalConfirmer() {
        executor.setRemoveOnCancelPolicy(true);
        tasks = new HashMap<>();
    }

    public HashMap<Long, ScheduledFuture<?>> getTasks() {
        return tasks;
    }

    public void setupDatabaseRentals() {
        List<Rental> rentals;
        try {
            rentals = new RentalLogicImpl().findConcluded();
        } catch (LogicException e) {
            throw new ConfirmerException("Error occurred when setting up confirmer", e);
        }
        for (Rental rental : rentals) {
            addTask(new ConfirmTask(rental));
        }
    }

    public void addTask(ConfirmTask task) {
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
