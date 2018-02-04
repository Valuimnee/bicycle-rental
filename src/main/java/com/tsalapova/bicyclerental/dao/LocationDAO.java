package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface LocationDAO extends GeneralDAO<Location> {
    List<Location> findAll() throws DAOException;
}
