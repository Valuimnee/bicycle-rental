package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * The interface of DAO layer that works with Location entity
 *
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface LocationDAO extends GeneralDAO<Location> {
    /**
     * Method finds all locations of the rental system and returns them in {@code List}
     *
     * @return {@code List} of locations
     * @throws DAOException exception thrown in case error occurs
     */
    List<Location> findAll() throws DAOException;
}
