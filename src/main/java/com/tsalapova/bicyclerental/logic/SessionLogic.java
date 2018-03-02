package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public interface SessionLogic {
    boolean register(User user, String password, Client client, Account account) throws LogicException;

    void deleteClient(long clientId) throws LogicException;
}
