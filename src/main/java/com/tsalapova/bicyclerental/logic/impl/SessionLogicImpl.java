package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.generator.HashGenerator;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.logic.SessionLogic;
import com.tsalapova.bicyclerental.util.EntityAction;
import javafx.util.Pair;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class SessionLogicImpl implements SessionLogic {
    private UserDAO userDAO;

    public SessionLogicImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean register(User user, String password, Client client, Account account) throws DAOException {
        long id = userDAO.findIdByLogin(user.getLogin());
        if (id != -1L) {
            return false;
        }
        Pair<String, String> hashSalt = new HashGenerator().generateHashSalt(password);
        user.setPassword(hashSalt.getKey());
        user.setSalt(hashSalt.getValue());
        userDAO.add(user);
        id = userDAO.findIdByLogin(user.getLogin());
        if (id == -1L) {
            return false;
        }
        user.setId(id);
        client.setClientId(id);
        client.setPhone(new EntityAction().formatPhone(client.getPhone()));
        account.setClientId(id);
        LogicInjector logicInjector=new LogicInjector();
        logicInjector.getDaoInjector().getClientDAO().add(client);
        logicInjector.getDaoInjector().getAccountDAO().add(account);
        return true;
    }

    @Override
    public void deleteClient(long clientId) throws DAOException {
        userDAO.deleteById(clientId);
    }
}
