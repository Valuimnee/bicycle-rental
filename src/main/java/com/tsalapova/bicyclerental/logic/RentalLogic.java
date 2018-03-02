package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.LogicException;
import javafx.util.Pair;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalLogic {
    void createRental(Rental rental) throws LogicException;

    Pair<List<Rental>, List<Bicycle>> displayByClientId(long clientId) throws LogicException;

    Pair<List<Rental>, List<Bicycle>> displayCurrentByClientId(long clientId) throws LogicException;

    List<Rental> findConcluded() throws LogicException;

    List<Entity> displayById(long rentalId) throws LogicException;

    void cancelById(long rentalId) throws LogicException;

    void confirmById(long rentalId) throws LogicException;

    void editTimeHours(Rental rental) throws LogicException;

    Long countByClientId(long clientId) throws LogicException;
}
