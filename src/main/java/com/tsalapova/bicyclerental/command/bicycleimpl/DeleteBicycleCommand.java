package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
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
public class DeleteBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        Bicycle bicycle=(Bicycle)session.getAttribute(SessionConstant.BICYCLE);
        try {
            new BicycleLogicImpl().deleteById(bicycle.getBicycleId());
        } catch (LogicException e) {
            throw new CommandException("Error occurred when deleting the bicycle", e);
        }
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.LOCATION);
        return PageConstant.ADMIN;
    }
}
