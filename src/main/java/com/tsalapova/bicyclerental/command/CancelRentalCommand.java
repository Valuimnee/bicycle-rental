package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class CancelRentalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        long rentalId=Long.valueOf(request.getParameter(DocumentConstant.RENTAL_ID));
        try {
            new RentalLogicImpl().cancel(rentalId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when canceling rental", e);
        }
        return PageConstant.MAIN;
    }
}
