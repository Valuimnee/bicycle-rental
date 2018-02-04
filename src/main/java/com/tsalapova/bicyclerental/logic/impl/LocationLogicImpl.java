package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.LocationDAOImpl;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.LocationLogic;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class LocationLogicImpl implements LocationLogic {
    @Override
    public List<Location> displayAll() throws LogicException {
        try {
            return new LocationDAOImpl().findAll();
        } catch (DAOException e) {
            throw new LogicException("Error occurred when displaying locations.", e);
        }
    }
}
