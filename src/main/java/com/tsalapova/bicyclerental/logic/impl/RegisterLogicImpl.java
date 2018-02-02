package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.ClientDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.UserDAOImpl;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.generator.HashGenerator;
import com.tsalapova.bicyclerental.logic.RegisterLogic;
import javafx.util.Pair;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class RegisterLogicImpl implements RegisterLogic {
    @Override
    public boolean register(User user, String password, Client client) throws LogicException {
        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            long id=userDAO.findIdByLogin(user.getLogin());
            if(id!= -1L){
                return false;
            }
            Pair<String, String> hashSalt=new HashGenerator().generateHashSalt(password);
            user.setPassword(hashSalt.getKey());
            user.setSalt(hashSalt.getValue());
            userDAO.addClient(user);
            id = userDAO.findIdByLogin(user.getLogin());
            if(id==-1L){
                return false;
            }
            user.setId(id);
            client.setClientId(id);
            new ClientDAOImpl().add(client);
            return true;
        } catch (DAOException e) {
            throw new LogicException("Registration error. "+e.getMessage(), e);
        }
    }
}
