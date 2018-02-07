package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.BicycleDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.RentalDAOImpl;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.RentalLogic;
import javafx.util.Pair;

import java.util.HashMap;
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
    public Pair<List<Rental>,List<Bicycle>> displayByClientId(long clientId) throws LogicException {
        try {
           List<Rental> rentals= new RentalDAOImpl().findByClientId(clientId);
           if(rentals.isEmpty()){
               return new Pair<>(rentals, null);
           }
           List<Bicycle> bicycles=new BicycleDAOImpl().findByRentalsClientId(clientId);
            HashMap<Long, Bicycle> map=new HashMap<>();
            for (Bicycle bicycle: bicycles){
                map.put(bicycle.getBicycleId(), bicycle);
            }
            bicycles.clear();
            for(Rental rental: rentals){
                bicycles.add(map.get(rental.getBicycleId()));
            }
            map.clear();
            return new Pair<>(rentals, bicycles);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying all rentals", e);
        }
    }
}
