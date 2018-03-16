package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.generator.HashGenerator;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.logic.UserLogic;
import javafx.util.Pair;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class UserLogicImpl implements UserLogic {
    private UserDAO userDAO;

    public UserLogicImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean login(User currentUser) throws DAOException {
        User user;
        user = userDAO.findByLogin(currentUser.getLogin());
        if (user != null) {
            String hash = new HashGenerator().generateHash(currentUser.getPassword(), user.getSalt());
            if(hash.equals(user.getPassword())) {
                if (user.getRole().equals(UserRole.CLIENT.getName()) &&
                        new LogicInjector().getClientLogic().displayProfile(user.getId()).getActive() == (byte) 0) {
                    return false;
                }else{
                    currentUser.setId(user.getId());
                    currentUser.setRole(user.getRole());
                }
            }
        }
        return true;
    }

    @Override
    public boolean update(User currentUser, User newUser) throws DAOException {
        HashGenerator hashGenerator = new HashGenerator();
        User user = userDAO.findByLogin(currentUser.getLogin());
        if (!user.getLogin().equals(newUser.getLogin())) {
            if (userDAO.findIdByLogin(newUser.getLogin()) != -1L) {
                return false;
            }
            userDAO.updateLogin(user.getId(), newUser.getLogin());
            user.setLogin(newUser.getLogin());
        }
        if (currentUser.getPassword().isEmpty() && newUser.getPassword().isEmpty()) {
            return true;
        }
        if (!user.getPassword().equals(hashGenerator.generateHash(currentUser.getPassword(), user.getSalt()))) {
            return false;
        }
        Pair<String, String> hashSalt = hashGenerator.generateHashSalt(newUser.getPassword());
        user.setPassword(hashSalt.getKey());
        user.setSalt(hashSalt.getValue());
        userDAO.updateHashSalt(user);
        return true;
    }

    @Override
    public User findById(long userId) throws DAOException {
        User user = userDAO.findById(userId);
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }
}
