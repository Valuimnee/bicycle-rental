package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class AddBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Bicycle bicycle = new Bicycle();
        if (!defineBicycle(request, bicycle)) {
            setToRequestMaterialsTypes(request);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.ADD_BICYCLE);
            return PageConstant.ADMIN;
        }
        BicycleLogic logic = new LogicInjector().getBicycleLogic();
        try {
            logic.add(bicycle);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when adding the bike", e);
        }
        return PageConstant.ADMIN;
    }
}
