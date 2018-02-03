package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public interface ClientDAO extends GeneralDAO<Client> {
    void add(Client client) throws DAOException;
    Client findById(long clientId) throws DAOException;
    void update(Client client) throws DAOException;
}
