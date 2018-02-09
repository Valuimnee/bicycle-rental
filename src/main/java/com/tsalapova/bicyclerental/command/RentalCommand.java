package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.util.EntityAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class RentalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        long rentalId=Long.valueOf(request.getParameter(DocumentConstant.RENTAL_ID));
        List<Entity> entities;
        try {
            entities=new RentalLogicImpl().displayById(rentalId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying rental", e);
        }

        if(entities.isEmpty()){
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_RENTAL);
            return PageConstant.MAIN;
        }

        session.setAttribute(SessionConstant.LOCATION, entities.get(0));
        session.setAttribute(SessionConstant.BICYCLE, entities.get(1));
        session.setAttribute(SessionConstant.RENTAL, entities.get(2));

        request.setAttribute(RequestConstant.DATETIME, new EntityAction().defineDateTime(((Rental)entities.get(2)).getStartTime()));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
        return PageConstant.MAIN;
    }
}
