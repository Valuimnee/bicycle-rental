package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.command.PageConstant;
import com.tsalapova.bicyclerental.command.RequestConstant;
import com.tsalapova.bicyclerental.command.SessionConstant;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/10/2018
 */
public class EditBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        Bicycle bicycle=(Bicycle)session.getAttribute(SessionConstant.BICYCLE);
        if(!defineBicycle(request, bicycle)){
            setMaterialsTypes(request);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.BICYCLE);
            return PageConstant.ADMIN;
        }
        try {
            new BicycleLogicImpl().edit(bicycle);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when updating the bike", e);
        }
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.LOCATION);
        return PageConstant.ADMIN;
    }
}
