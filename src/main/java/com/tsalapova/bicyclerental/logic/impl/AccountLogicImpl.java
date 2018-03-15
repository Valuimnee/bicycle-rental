package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.AccountDAO;
import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.AccountLogic;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class AccountLogicImpl implements AccountLogic {
    private AccountDAO accountDAO;

    public AccountLogicImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account findByClientId(long clientId) throws DAOException {
        return accountDAO.findById(clientId);
    }

    @Override
    public void payRental(long clientId, double total) throws DAOException {
        accountDAO.update(clientId, total);
    }
}
