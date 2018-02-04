package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public interface BicycleDAO extends GeneralDAO<Bicycle> {
    List<Bicycle> findByLocation(long locationId) throws DAOException;
    List<Bicycle> findAll() throws DAOException;
}
