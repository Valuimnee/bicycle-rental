package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.ClientDAO;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.ClientLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.EntityAction;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class ClientLogicImpl implements ClientLogic {
    private ClientDAO clientDAO;

    public ClientLogicImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client displayProfile(long clientId) throws DAOException {
        return clientDAO.findById(clientId);
    }

    @Override
    public void update(Client client) throws DAOException {
        client.setPhone(new EntityAction().formatPhone(client.getPhone()));
        clientDAO.update(client);
    }

    @Override
    public List<List> displayAll() throws DAOException {
        List<Client> clients = clientDAO.findAll();
        if (clients.isEmpty()) {
            return new ArrayList<>();
        }
        LogicInjector logicInjector=new LogicInjector();
        List<User> users = logicInjector.getDaoInjector().getUserDAO().findByRole(UserRole.CLIENT);
        HashMap<Long, User> map = new HashMap<>();
        for (User user : users) {
            map.put(user.getId(), user);
        }
        List<String> logins = new ArrayList<>(clients.size());
        HashMap<Long, Long> countMap = new HashMap<>();
        for (Pair<Long, Long> pair : logicInjector.getDaoInjector().getRentalDAO().countAllByClientId()) {
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
    }

    @Override
    public void changeActiveById(long clientId, byte active) throws DAOException {
        clientDAO.changeStatusById(clientId, active);
    }
}
