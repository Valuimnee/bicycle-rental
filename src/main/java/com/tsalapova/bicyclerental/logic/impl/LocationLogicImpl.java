package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.LocationDAO;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LocationLogic;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class LocationLogicImpl implements LocationLogic {
    private LocationDAO locationDAO;

    public LocationLogicImpl(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Override
    public Location displayById(long locationId) throws DAOException {
        return locationDAO.findById(locationId);
    }

    @Override
    public List<Location> displayAll() throws DAOException {
        return locationDAO.findAll();
    }
}
