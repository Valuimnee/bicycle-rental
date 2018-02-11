package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.PageConstant;
import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.command.SessionConstant;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public class RentCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Rental rental = (Rental) session.getAttribute(SessionConstant.RENTAL);

        try {
            new RentalLogicImpl().createRental(rental);
        } catch (LogicException e) {
            throw new CommandException("Error occurred while renting the bicycle", e);
        }

        session.removeAttribute(SessionConstant.LOCATION);
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.RENTAL);

        return PageConstant.MAIN;
    }
}
