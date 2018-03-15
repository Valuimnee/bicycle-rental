package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.BicycleDAO;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public class BicycleLogicImpl implements BicycleLogic {
    private BicycleDAO bicycleDAO;

    public BicycleLogicImpl(BicycleDAO bicycleDAO) {
        this.bicycleDAO = bicycleDAO;
    }

    @Override
    public Bicycle displayById(long bicycleId) throws DAOException {
        return bicycleDAO.findById(bicycleId);
    }

    @Override
    public List<Bicycle> displayByLocation(long locationId) throws DAOException {
        return bicycleDAO.findByLocation(locationId);
    }

    @Override
    public List<Bicycle> displayAllAvailable() throws DAOException {
        return bicycleDAO.findAllAvailable();
    }

    @Override
    public List<Bicycle> displayAll() throws DAOException {
        return bicycleDAO.findAll();
    }

    @Override
    public void add(Bicycle bicycle) throws DAOException {
        bicycleDAO.add(bicycle);
    }

    @Override
    public void deleteById(long bicycleId) throws DAOException {
        bicycleDAO.deleteById(bicycleId);
    }

    @Override
    public void edit(Bicycle bicycle) throws DAOException {
        bicycleDAO.update(bicycle);
    }

    @Override
    public void deleteLocation(long bicycleId) throws DAOException {
        bicycleDAO.deleteLocationById(bicycleId);
    }

    @Override
    public void assignLocation(long bicycleId, long locationId) throws DAOException{
        bicycleDAO.assignLocationById(bicycleId, locationId);
    }
}
