package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalDAO extends GeneralDAO<Rental> {
    void add(Rental rental) throws DAOException;
    List<Rental> findByClientId(long clientId) throws DAOException;
}
