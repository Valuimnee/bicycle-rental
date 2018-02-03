package com.tsalapova.bicyclerental.logic.impl;

import com.tsalapova.bicyclerental.dao.impl.UserDAOImpl;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.DeleteAccountLogic;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class DeleteAccountLogicImpl implements DeleteAccountLogic {
    @Override
    public void deleteClient(long clientId) throws LogicException {
        try {
            new UserDAOImpl().deleteById(clientId);
        } catch (DAOException e) {
            throw new LogicException("Error occurred while deleting account", e);
        }
    }
}
