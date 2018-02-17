package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConfirmerException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class RentalConfirmer {
    private static RentalConfirmer instance = new RentalConfirmer();

    private ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(20);
    private HashMap<Long, ScheduledFuture<?>> tasks;
    public static RentalConfirmer getInstance() {
        return instance;
    }


    private RentalConfirmer() {
        executor.setRemoveOnCancelPolicy(true);
        tasks=new HashMap<>();
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
        long delay = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond() - task.getTime() / 1000L;
        ScheduledFuture<?> future=executor.schedule(task, delay, TimeUnit.SECONDS);
        tasks.put(task.getRentalId(), future);
    }

    public void removeTask(long rentalId){
        ScheduledFuture<?> future=tasks.get(rentalId);
        future.cancel(false);
    }

    public void shutdown(){
        executor.shutdownNow();
    }
}
