package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public interface UserDAO extends GeneralDAO<User> {
    User findByLogin(String login) throws DAOException;
}
