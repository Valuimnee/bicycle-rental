package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface DeleteAccountLogic {
    void deleteClient(long clientId) throws LogicException;
}
