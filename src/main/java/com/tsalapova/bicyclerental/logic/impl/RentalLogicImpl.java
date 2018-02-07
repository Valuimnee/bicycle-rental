package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.RentalDAOImpl;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.RentalLogic;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public class RentalLogicImpl implements RentalLogic {
    @Override
    public void createRental(Rental rental) throws LogicException {
        try {
            new RentalDAOImpl().add(rental);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when creating rental", e);
        }
    }

    @Override
    public List<Rental> displayByClientId(long clientId) throws LogicException {
        try {
           return new RentalDAOImpl().findByClientId(clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying all rentals", e);
        }
    }
}
