package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface AccountDAO extends GeneralDAO<Account> {
    void update(long clientId, double total) throws DAOException;
    void add(Account account) throws DAOException;
    Account findByClientId(long clientId) throws DAOException;
}
