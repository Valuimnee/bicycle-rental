package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface ClientLogic {
    Client displayProfile(long clientId) throws LogicException;
    void update(Client client) throws LogicException;
}
