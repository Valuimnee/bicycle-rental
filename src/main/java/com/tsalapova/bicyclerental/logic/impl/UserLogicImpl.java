package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.UserDAOImpl;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.generator.HashGenerator;
import com.tsalapova.bicyclerental.logic.UserLogic;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class UserLogicImpl implements UserLogic {
    @Override
    public User login(String login, String password) throws LogicException {
        try {
            User user = new UserDAOImpl().findByLogin(login);
            if (user != null) {
                String hash = new HashGenerator().generateHash(password, user.getSalt());
                if (hash.equals(user.getPassword())) {
                    return user;
                }
            }
            return null;
        } catch (DAOException e) {
            throw new LogicException("Authentication error.", e);
        }
    }
}
