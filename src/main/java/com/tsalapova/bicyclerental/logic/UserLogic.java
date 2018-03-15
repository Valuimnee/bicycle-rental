package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public interface UserLogic {
    User findById(long userId) throws DAOException;

    boolean login(User currentUser) throws DAOException;

    boolean update(User currentUser, User newUser) throws DAOException;
}
