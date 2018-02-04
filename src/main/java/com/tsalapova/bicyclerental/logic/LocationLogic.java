package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.LogicException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface LocationLogic {
    List<Location> displayAll() throws LogicException;
}
