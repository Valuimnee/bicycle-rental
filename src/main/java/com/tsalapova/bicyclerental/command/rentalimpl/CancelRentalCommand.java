package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class CancelRentalCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        long rentalId = Long.valueOf(request.getParameter(DocumentConstant.RENTAL_ID));
        new LogicInjector().getRentalLogic().cancelById(rentalId);
        removeRentalFromSession(request.getSession());
        return PageConstant.MAIN;
    }
}
