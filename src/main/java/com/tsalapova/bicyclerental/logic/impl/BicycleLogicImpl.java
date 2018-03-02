package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.BicycleDAOImpl;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public class BicycleLogicImpl implements BicycleLogic {
    @Override
    public Bicycle displayById(long bicycleId) throws LogicException {
        try {
            return new BicycleDAOImpl().findById(bicycleId);
        } catch (DAOException e) {
            throw new LogicException("Error while displaying the bike", e);
        }
    }

    @Override
    public List<Bicycle> displayByLocation(long locationId) throws LogicException {
        try {
            return new BicycleDAOImpl().findByLocation(locationId);
        } catch (DAOException e) {
            throw new LogicException("Error while displaying all bikes of location", e);
        }
    }

    @Override
    public List<Bicycle> displayAllAvailable() throws LogicException {
        try {
            return new BicycleDAOImpl().findAllAvailable();
        } catch (DAOException e) {
            throw new LogicException("Error while displaying all available bikes", e);
        }
    }

    @Override
    public List<Bicycle> displayAll() throws LogicException {
        try {
            return new BicycleDAOImpl().findAll();
        } catch (DAOException e) {
            throw new LogicException("Error while displaying all bikes", e);
        }
    }

    @Override
    public void add(Bicycle bicycle) throws LogicException {
        try {
            new BicycleDAOImpl().add(bicycle);
        } catch (DAOException e) {
            throw new LogicException("Error while adding new bike", e);
        }
    }

    @Override
    public void deleteById(long bicycleId) throws LogicException {
        try {
            new BicycleDAOImpl().deleteById(bicycleId);
        } catch (DAOException e) {
            throw new LogicException("Error while deleting the bike", e);
        }
    }

    @Override
    public void edit(Bicycle bicycle) throws LogicException {
        try {
            new BicycleDAOImpl().update(bicycle);
        } catch (DAOException e) {
            throw new LogicException("Error while editing the bike", e);
        }
    }

    @Override
    public void deleteLocation(long bicycleId) throws LogicException {
        try {
            new BicycleDAOImpl().deleteLocationById(bicycleId);
        } catch (DAOException e) {
            throw new LogicException("Error while deleting bike's location", e);
        }
    }

    @Override
    public void assignLocation(long bicycleId, long locationId) throws LogicException {
        try {
            new BicycleDAOImpl().assignLocationById(bicycleId, locationId);
        } catch (DAOException e) {
            throw new LogicException("Error while setting location of the bike", e);
        }
    }
}
