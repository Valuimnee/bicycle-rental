package com.tsalapova.bicyclerental.logic;

import com.tsalapova.bicyclerental.dao.DAOInjector;
import com.tsalapova.bicyclerental.logic.impl.AccountLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.LocationLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.SessionLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.UserLogicImpl;

/**
 * @author TsalapovaMD
 * @version 1.0, 3/14/2018
 */
public class LogicInjector {
    private DAOInjector daoInjector;

    public LogicInjector() {
        daoInjector = new DAOInjector();
    }

    public DAOInjector getDaoInjector() {
        return daoInjector;
    }

    public AccountLogic getAccountLogic() {
        return new AccountLogicImpl(daoInjector.getAccountDAO());
    }

    public BicycleLogic getBicycleLogic() {
        return new BicycleLogicImpl(daoInjector.getBicycleDAO());
    }

    public ClientLogic getClientLogic() {
        return new ClientLogicImpl(daoInjector.getClientDAO());
    }

    public LocationLogic getLocationLogic() {
        return new LocationLogicImpl(daoInjector.getLocationDAO());
    }

    public RentalLogic getRentalLogic() {
        return new RentalLogicImpl(daoInjector.getRentalDAO());
    }

    public SessionLogic getSessionLogic() {
        return new SessionLogicImpl(daoInjector.getUserDAO());
    }

    public UserLogic getUserLogic() {
        return new UserLogicImpl(daoInjector.getUserDAO());
    }

}
