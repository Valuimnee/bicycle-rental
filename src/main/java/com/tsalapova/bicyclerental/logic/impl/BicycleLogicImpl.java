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
    public List<Bicycle> displayByLocation(long locationId) throws LogicException {
        try {
            return new BicycleDAOImpl().findByLocation(locationId);
        } catch (DAOException e) {
            throw new LogicException("Error while displaying all bikes of location.", e);
        }
    }

    @Override
    public List<Bicycle> displayAll() throws LogicException {
        try {
            return new BicycleDAOImpl().findAll();
        } catch (DAOException e) {
            throw new LogicException("Error while displaying all bikes.", e);
        }
    }
}
