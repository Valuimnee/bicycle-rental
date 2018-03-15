package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.dao.impl.*;

/**
 * @author TsalapovaMD
 * @version 1.0, 3/15/2018
 */
public class DAOInjector {
    public AccountDAO getAccountDAO() {
        return new AccountDAOImpl();
    }

    public BicycleDAO getBicycleDAO() {
        return new BicycleDAOImpl();
    }

    public ClientDAO getClientDAO() {
        return new ClientDAOImpl();
    }

    public LocationDAO getLocationDAO() {
        return new LocationDAOImpl();
    }

    public RentalDAO getRentalDAO() {
        return new RentalDAOImpl();
    }

    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
}
