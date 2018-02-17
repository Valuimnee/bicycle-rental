package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class AssignLocationCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
        Long locationId = Long.valueOf(request.getParameter(DocumentConstant.LOCATION_ID));
        try {
            new BicycleLogicImpl().assignLocation(bicycle.getBicycleId(), locationId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when setting location of the bike", e);
        }
        removeBicycleFromSession(session);
        return PageConstant.ADMIN;
    }
}
