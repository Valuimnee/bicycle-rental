package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.confirmer.ConfirmTask;
import com.tsalapova.bicyclerental.confirmer.RentalConfirmer;
import com.tsalapova.bicyclerental.dao.impl.BicycleDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.LocationDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.RentalDAOImpl;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.RentalLogic;
import javafx.util.Pair;

import java.util.ArrayList;
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
            Rental newRental=new RentalDAOImpl().add(rental);
            RentalConfirmer.getInstance().addTask(new ConfirmTask(newRental));
        } catch (DAOException e) {
            throw new LogicException("Error occurred when creating rental", e);
        }
    }

    private Pair<List<Rental>, List<Bicycle>> displayRentalsBicycles(List<Rental> rentals, long clientId) throws DAOException {
        if (rentals.isEmpty()) {
            return new Pair<>(rentals, null);
        }
        List<Bicycle> bicycles = new BicycleDAOImpl().findByRentalsClientId(clientId);
        HashMap<Long, Bicycle> map = new HashMap<>();
        for (Bicycle bicycle : bicycles) {
            map.put(bicycle.getBicycleId(), bicycle);
        }
        bicycles.clear();
        for (Rental rental : rentals) {
            bicycles.add(map.get(rental.getBicycleId()));
        }
        map.clear();
        return new Pair<>(rentals, bicycles);
    }

    @Override
    public Pair<List<Rental>, List<Bicycle>> displayByClientId(long clientId) throws LogicException {
        try {
            List<Rental> rentals = new RentalDAOImpl().findByClientId(clientId);
            return displayRentalsBicycles(rentals, clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying all rentals", e);
        }
    }

    @Override
    public Pair<List<Rental>, List<Bicycle>> displayCurrentByClientId(long clientId) throws LogicException {
        try {
            List<Rental> rentals = new RentalDAOImpl().findConcludedByClientId(clientId);
            return displayRentalsBicycles(rentals, clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying all rentals", e);
        }
    }

    @Override
    public List<Rental> findConcluded() throws LogicException {
        try {
            return new RentalDAOImpl().findConcluded();
        } catch (DAOException e) {
            throw new LogicException("Error occurred when fetching concluded rentals", e);
        }
    }

    @Override
    public List<Entity> displayById(long rentalId) throws LogicException {
        List<Entity> entities=new ArrayList<>(3);
        Rental rental;
        Bicycle bicycle;
        Location location;
        try {
            rental=new RentalDAOImpl().findById(rentalId);
            if(rental==null){
                return entities;
            }
            bicycle=new BicycleDAOImpl().findById(rental.getBicycleId());
            if(bicycle==null){
                return entities;
            }
            location=new LocationDAOImpl().findById(bicycle.getLocationId());
            if(location==null){
                return entities;
            }
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying rental", e);
        }
        entities.add(location);
        entities.add(bicycle);
        entities.add(rental);
        return entities;
    }

    @Override
    public void cancelById(long rentalId) throws LogicException {
        try {
            new RentalDAOImpl().cancelById(rentalId);
            RentalConfirmer.getInstance().removeTask(rentalId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when canceling rental", e);
        }
    }

    @Override
    public void confirmById(long rentalId) throws LogicException {
        try {
            new RentalDAOImpl().confirmById(rentalId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when confirming rental", e);
        }
    }

    @Override
    public void editTimeHours(Rental rental) throws LogicException {
        try {
            new RentalDAOImpl().updateTimeHours(rental);
            RentalConfirmer confirmer=RentalConfirmer.getInstance();
            confirmer.removeTask(rental.getRentalId());
            confirmer.addTask(new ConfirmTask(rental));
        } catch (DAOException e) {
            throw new LogicException("Error occurred when updating rental", e);
        }
    }

    @Override
    public Long countByClientId(long clientId) throws LogicException {
        try {
            return new RentalDAOImpl().countByClientId(clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when finding rental count of client", e);
        }
    }
}
