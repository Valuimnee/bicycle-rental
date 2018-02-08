package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class RentalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
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

        request.setAttribute(RequestConstant.LOCATION, entities.get(0));
        request.setAttribute(RequestConstant.BICYCLE, entities.get(1));
        request.setAttribute(RequestConstant.RENTAL, entities.get(2));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
        return PageConstant.MAIN;
    }
}
