package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.confirmer.RentalConfirmationTask;
import com.tsalapova.bicyclerental.confirmer.TaskExecutor;
import com.tsalapova.bicyclerental.dao.RentalDAO;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
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
    private RentalDAO rentalDAO;

    public RentalLogicImpl(RentalDAO rentalDAO) {
        this.rentalDAO = rentalDAO;
    }

    @Override
    public void createRental(Rental rental) throws DAOException {
        rentalDAO.add(rental);
        Rental newRental = rentalDAO.findByParameters(rental);
        TaskExecutor.getInstance().addTask(new RentalConfirmationTask(newRental));
    }

    private Pair<List<Rental>, List<Bicycle>> displayRentalsBicycles(List<Rental> rentals, long clientId) throws DAOException {
        if (rentals.isEmpty()) {
            return new Pair<>(rentals, null);
        }
        LogicInjector logicInjector=new LogicInjector();
        List<Bicycle> bicycles = logicInjector.getDaoInjector().getBicycleDAO().findByRentalsClientId(clientId);
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
    public Pair<List<Rental>, List<Bicycle>> displayByClientId(long clientId) throws DAOException {
        List<Rental> rentals = rentalDAO.findByClientId(clientId);
        return displayRentalsBicycles(rentals, clientId);
    }

    @Override
    public Pair<List<Rental>, List<Bicycle>> displayCurrentByClientId(long clientId) throws DAOException {
        List<Rental> rentals = rentalDAO.findConcludedByClientId(clientId);
        return displayRentalsBicycles(rentals, clientId);
    }

    @Override
    public List<Rental> findConcluded() throws DAOException {
        return rentalDAO.findConcluded();
    }

    @Override
    public List<Entity> displayById(long rentalId) throws DAOException {
        List<Entity> entities = new ArrayList<>(3);
        Rental rental;
        Bicycle bicycle;
        Location location;
        rental = rentalDAO.findById(rentalId);
        if (rental == null) {
            return entities;
        }
        LogicInjector logicInjector=new LogicInjector();
        bicycle = logicInjector.getDaoInjector().getBicycleDAO().findById(rental.getBicycleId());
        if (bicycle == null) {
            return entities;
        }
        location = logicInjector.getDaoInjector().getLocationDAO().findById(bicycle.getLocationId());
        if (location == null) {
            return entities;
        }
        entities.add(location);
        entities.add(bicycle);
        entities.add(rental);
        return entities;
    }

    @Override
    public void cancelById(long rentalId) throws DAOException {
        rentalDAO.cancelById(rentalId);
        TaskExecutor.getInstance().removeTask(rentalId);
    }

    @Override
    public void confirmById(long rentalId) throws DAOException {
        rentalDAO.confirmById(rentalId);
    }

    @Override
    public void editTimeHours(Rental rental) throws DAOException {
        rentalDAO.updateTimeHours(rental);
        TaskExecutor confirmer = TaskExecutor.getInstance();
        confirmer.removeTask(rental.getRentalId());
        confirmer.addTask(new RentalConfirmationTask(rental));
    }

    @Override
    public Long countByClientId(long clientId) throws DAOException {
        return rentalDAO.countByClientId(clientId);
    }
}
