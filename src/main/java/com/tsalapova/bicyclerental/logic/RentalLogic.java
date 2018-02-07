package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.LogicException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalLogic {
    void createRental(Rental rental) throws LogicException;
    List<Rental> displayByClientId(long clientId) throws LogicException;
}
