package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.AccountDAOImpl;
import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.AccountLogic;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class AccountLogicImpl implements AccountLogic {
    @Override
    public void payRental(long clientId, double total) throws LogicException {
        try {
            new AccountDAOImpl().update(clientId, total);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when paying client rental", e);
        }
    }

    @Override
    public Account findByClientId(long clientId) throws LogicException {
        try {
            return new AccountDAOImpl().findByClientId(clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred when finding client account", e);
        }
    }

}
