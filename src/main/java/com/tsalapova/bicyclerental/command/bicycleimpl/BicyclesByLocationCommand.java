package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.command.DocumentConstant;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;

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
        try {
            bicycles = new BicycleLogicImpl().displayByLocation(locationId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying bicycles of location", e);
        }
        return setToRequestBicycles(bicycles, request);
    }
}
