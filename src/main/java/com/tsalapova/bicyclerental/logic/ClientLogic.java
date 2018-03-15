package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public interface ClientLogic {
    Client displayProfile(long clientId) throws DAOException;

    void update(Client client) throws DAOException;

    List<List> displayAll() throws DAOException;

    void changeActiveById(long clientId, byte active) throws DAOException;
}
