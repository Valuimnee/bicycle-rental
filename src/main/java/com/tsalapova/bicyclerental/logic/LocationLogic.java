package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface LocationLogic {
    Location displayById(long locationId) throws DAOException;

    List<Location> displayAll() throws DAOException;
}
