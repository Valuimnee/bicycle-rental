package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.ClientDAOImpl;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.ClientLogic;

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
}
