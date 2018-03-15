package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import javafx.util.Pair;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalLogic {
    void createRental(Rental rental) throws DAOException;

    Pair<List<Rental>, List<Bicycle>> displayByClientId(long clientId) throws DAOException;

    Pair<List<Rental>, List<Bicycle>> displayCurrentByClientId(long clientId) throws DAOException;

    List<Rental> findConcluded() throws DAOException;

    List<Entity> displayById(long rentalId) throws DAOException;

    void cancelById(long rentalId) throws DAOException;

    void confirmById(long rentalId) throws DAOException;

    void editTimeHours(Rental rental) throws DAOException;

    Long countByClientId(long clientId) throws DAOException;
}
