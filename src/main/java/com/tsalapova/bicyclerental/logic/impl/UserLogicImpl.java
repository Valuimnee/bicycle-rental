package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.dao.impl.UserDAOImpl;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.generator.HashGenerator;
import com.tsalapova.bicyclerental.logic.UserLogic;
import javafx.util.Pair;

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

    @Override
    public boolean update(String login, String password, String newLogin, String newPassword) throws LogicException {
        UserDAO userDAO = new UserDAOImpl();
        HashGenerator hashGenerator = new HashGenerator();
        try {
            User user = userDAO.findByLogin(login);
            if (!user.getLogin().equals(newLogin)) {
                if(userDAO.findIdByLogin(newLogin)!=-1L){
                    return false;
                }
                userDAO.updateLogin(user.getId(), newLogin);
                user.setLogin(newLogin);
            }
            if (password.isEmpty() && newPassword.isEmpty()) {
                return true;
            }
            if (!user.getPassword().equals(hashGenerator.generateHash(password, user.getSalt()))) {
                return false;
            }
            Pair<String, String> hashSalt = hashGenerator.generateHashSalt(newPassword);
            user.setPassword(hashSalt.getKey());
            user.setSalt(hashSalt.getValue());
            userDAO.updateHashSalt(user);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when updating user account.", e);
        }
        return true;
    }
}
