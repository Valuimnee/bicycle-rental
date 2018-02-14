package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.util.EntityAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class EditRentalCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Rental rental = (Rental) session.getAttribute(SessionConstant.RENTAL);
        if (!defineDateHours(request, rental)) {
            request.setAttribute(RequestConstant.DATETIME, new EntityAction().defineDateTime(rental.getStartTime()));
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
            return PageConstant.MAIN;
        }
        try {
            new RentalLogicImpl().editTimeHours(rental);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when updating rental", e);
        }
        removeRentalFromSession(session);
        return PageConstant.MAIN;
    }
}