package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.*;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.util.EntityAction;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class EditRentalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        EntityAction action=new EntityAction();

        Rental rental=(Rental)session.getAttribute(SessionConstant.RENTAL);

        Timestamp timestamp = action.defineTimestamp(request.getParameter(DocumentConstant.START_DATE));
        int hours = Integer.valueOf(request.getParameter(DocumentConstant.HOURS));

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateStartTime(timestamp) || !validator.validateHours(hours)) {
            request.setAttribute(RequestConstant.DATETIME, action.defineDateTime(rental.getStartTime()));
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
            return PageConstant.MAIN;
        }


        rental.setStartTime(timestamp);
        if(rental.getHours()!=hours){
            Bicycle bicycle=(Bicycle)session.getAttribute(SessionConstant.BICYCLE);
            rental.setHours(hours);
            rental.setTotal(action.countTotal(bicycle.getPricePh(), hours));
        }

        try {
            new RentalLogicImpl().editTimeHours(rental);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when updating rental", e);
        }

        session.removeAttribute(SessionConstant.LOCATION);
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.RENTAL);

        return PageConstant.MAIN;
    }
}
