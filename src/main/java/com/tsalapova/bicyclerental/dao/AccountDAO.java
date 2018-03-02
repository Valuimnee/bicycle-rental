package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * The interface of DAO layer that works with Account entity
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface AccountDAO extends GeneralDAO<Account> {
    /**
     * Method discards given total from account by its id
     * (discards sum from balance or adds it to given credit)
     *
     * @param clientId id of client whom account belong (also id of account)
     * @param total sum to discard from account
     * @throws DAOException exception thrown in case error occurs
     */
    void update(long clientId, double total) throws DAOException;
}
