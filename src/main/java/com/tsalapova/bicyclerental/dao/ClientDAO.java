package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * The interface of DAO layer that works with Client entity
 *
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public interface ClientDAO extends GeneralDAO<Client> {
    /**
     * Methods finds all client of rental system
     *
     * @return {@code List} of clients
     * @throws DAOException exception thrown in case error occurs
     */
    List<Client> findAll() throws DAOException;

    /**
     * Method updates client parameters
     *
     * @param client changed client
     * @throws DAOException exception thrown in case error occurs
     */
    void update(Client client) throws DAOException;

    /**
     * Method sets specified status (0 - blocked, 1 - active) to certain client
     *
     * @param clientId id of certain client
     * @param status   status to set
     * @throws DAOException exception thrown in case error occurs
     */
    void changeStatusById(long clientId, byte status) throws DAOException;
}
