package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConfirmerException;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;

import java.time.LocalDateTime;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class RentalConfirmationTask implements Runnable {
    private Rental rental;

    public RentalConfirmationTask(Rental rental) {
        this.rental = rental;
    }

    public LocalDateTime getLocalDateTime() {
        return rental.getStartTime().toLocalDateTime().plusHours(rental.getHours());
    }

    public long getRentalId() {
        return rental.getRentalId();
    }

    @Override
    public void run() {
        LogicInjector injector = new LogicInjector();
        try {
            injector.getAccountLogic().payRental(rental.getClientId(), rental.getTotal());
            injector.getRentalLogic().confirmById(rental.getRentalId());
        } catch (DAOException e) {
            throw new ConfirmerException("Error while paying the rental", e);
        }
    }
}
