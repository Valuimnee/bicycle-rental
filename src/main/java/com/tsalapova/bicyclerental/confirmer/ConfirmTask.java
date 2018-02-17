package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.exception.ConfirmerException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class ConfirmTask implements Runnable {
    private Rental rental;

    public ConfirmTask(Rental rental) {
        this.rental=rental;
    }

    public long getTime(){
        return rental.getStartTime().getTime();
    }

    public long getRentalId(){
        return rental.getRentalId();
    }

    @Override
    public void run() {
        try {
            new ClientLogicImpl().payRental(rental.getClientId(), rental.getTotal());
            new RentalLogicImpl().confirmById(rental.getRentalId());
        } catch (LogicException e) {
            throw new ConfirmerException("Error while paying the rental", e);
        }
    }
}
