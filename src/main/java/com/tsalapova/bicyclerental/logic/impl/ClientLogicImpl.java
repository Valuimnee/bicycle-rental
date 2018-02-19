package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.ClientDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.RentalDAOImpl;
import com.tsalapova.bicyclerental.dao.impl.UserDAOImpl;
import com.tsalapova.bicyclerental.entity.*;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.ClientLogic;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class ClientLogicImpl implements ClientLogic {
    @Override
    public Client displayProfile(long clientId) throws LogicException {
        try {
            return new ClientDAOImpl().findById(clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred while displaying profile", e);
        }
    }

    @Override
    public void update(Client client) throws LogicException {
        try {
            new ClientDAOImpl().update(client);
        } catch (DAOException e) {
            throw new LogicException("Error occurred while updating client information", e);
        }
    }

    @Override
    public List<List> displayAll() throws LogicException {
        try {
            List<Client> clients = new ClientDAOImpl().findAll();
            if (clients.isEmpty()) {
                return new ArrayList<>();
            }
            List<User> users = new UserDAOImpl().findByRole(UserRole.CLIENT);
            HashMap<Long, User> map = new HashMap<>();
            for (User user : users) {
                map.put(user.getId(), user);
            }
            List<String> logins = new ArrayList<>(clients.size());
            HashMap<Long, Long> countMap = new HashMap<>();
            for (Pair<Long, Long> pair : new RentalDAOImpl().countAllByClientId()) {
                countMap.put(pair.getKey(), pair.getValue());
            }
            List<Long> counts = new ArrayList<>(clients.size());
            for (Client client : clients) {
                logins.add(map.get(client.getClientId()).getLogin());
                counts.add(countMap.get(client.getClientId()));
            }
            List<List> content = new ArrayList<>(3);
            content.add(logins);
            content.add(clients);
            content.add(counts);
            return content;
        } catch (DAOException e) {
            throw new LogicException("Error occurred while displaying all clients", e);
        }
    }

    @Override
    public void changeActiveById(long clientId, byte active) throws LogicException {
        try {
            new ClientDAOImpl().changeStatusById(clientId, active);
        } catch (DAOException e) {
            throw new LogicException("Error occurred while updating client status", e);
        }
    }
}
