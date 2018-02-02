package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public interface RegisterLogic {
    boolean register(User user, String password, Client client) throws LogicException;
}
