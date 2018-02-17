package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.LogicException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public interface BicycleLogic {
    Bicycle displayById(long bicycleId) throws LogicException;
    List<Bicycle> displayByLocation(long locationId) throws LogicException;
    List<Bicycle> displayAllAvailable() throws LogicException;
    List<Bicycle> displayAll() throws LogicException;
    void add(Bicycle bicycle) throws LogicException;
    void deleteById(long bicycleId) throws LogicException;
    void edit(Bicycle bicycle) throws LogicException;
    void deleteLocation(long bicycleId) throws LogicException;
    void assignLocation(long bicycleId, long locationId) throws LogicException;
}
