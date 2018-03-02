package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConfirmerException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.AccountLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

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
        try {
            new AccountLogicImpl().payRental(rental.getClientId(), rental.getTotal());
            new RentalLogicImpl().confirmById(rental.getRentalId());
        } catch (LogicException e) {
            throw new ConfirmerException("Error while paying the rental", e);
        }
    }
}
