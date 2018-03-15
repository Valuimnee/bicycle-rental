package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.DocumentConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public class BicyclesByLocationCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        long locationId = Long.valueOf(request.getParameter(DocumentConstant.LOCATION_ID));
        List<Bicycle> bicycles;
        BicycleLogic logic = new LogicInjector().getBicycleLogic();
        try {
            bicycles = logic.displayByLocation(locationId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying bicycles of location", e);
        }
        return setToRequestBicycles(bicycles, request);
    }
}
