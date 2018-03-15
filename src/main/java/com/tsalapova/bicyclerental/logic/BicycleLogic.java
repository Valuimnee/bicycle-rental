package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public interface BicycleLogic {
    Bicycle displayById(long bicycleId) throws DAOException;

    List<Bicycle> displayByLocation(long locationId) throws DAOException;

    List<Bicycle> displayAllAvailable() throws DAOException;

    List<Bicycle> displayAll() throws DAOException;

    void add(Bicycle bicycle) throws DAOException;

    void deleteById(long bicycleId) throws DAOException;

    void edit(Bicycle bicycle) throws DAOException;

    void deleteLocation(long bicycleId) throws DAOException;

    void assignLocation(long bicycleId, long locationId) throws DAOException;
}
