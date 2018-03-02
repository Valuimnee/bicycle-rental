package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.LogicException;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public interface UserLogic {
    User findById(long userId) throws LogicException;

    boolean login(User currentUser) throws LogicException;

    boolean update(User currentUser, User newUser) throws LogicException;
}
