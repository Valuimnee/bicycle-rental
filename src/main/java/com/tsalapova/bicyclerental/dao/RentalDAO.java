package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import javafx.util.Pair;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalDAO extends GeneralDAO<Rental> {
    void add(Rental rental) throws DAOException;
    List<Rental> findByClientId(long clientId) throws DAOException;
    List<Rental> findConcludedByClientId(long clientId) throws DAOException;
    Rental findById(long rentalId) throws DAOException;
    void cancelById(long rentalId) throws DAOException;
    void updateTimeHours(Rental rental) throws DAOException;
    List<Pair<Long, Long>> countAllByClientId() throws DAOException;
    Long countByClientId(long clientId) throws DAOException;
}
