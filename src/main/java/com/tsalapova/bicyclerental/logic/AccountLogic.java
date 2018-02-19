package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/19/2018
 */
public interface AccountLogic {
    void payRental(long clientId, double total) throws LogicException;
    Account findByClientId(long clientId) throws LogicException;
}
