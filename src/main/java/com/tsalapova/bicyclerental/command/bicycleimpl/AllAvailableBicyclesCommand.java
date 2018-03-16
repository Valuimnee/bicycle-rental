package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public class AllAvailableBicyclesCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        List<Bicycle> bicycles;
        BicycleLogic logic = new LogicInjector().getBicycleLogic();
        bicycles = logic.displayAllAvailable();
        return setToRequestBicycles(bicycles, request);
    }
}
