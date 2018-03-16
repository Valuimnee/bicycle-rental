package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class ViewRentalCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession();
        long rentalId = Long.valueOf(request.getParameter(DocumentConstant.RENTAL_ID));
        List<Entity> entities = new LogicInjector().getRentalLogic().displayById(rentalId);
        if (entities.isEmpty()) {
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_RENTAL);
            return PageConstant.MAIN;
        }
        Rental rental = (Rental) entities.get(2);
        session.setAttribute(SessionConstant.LOCATION, entities.get(0));
        session.setAttribute(SessionConstant.BICYCLE, entities.get(1));
        session.setAttribute(SessionConstant.RENTAL, rental);
        request.setAttribute(RequestConstant.DATETIME, new EntityAction().defineDateTime(rental.getStartTime()));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
        return PageConstant.MAIN;
    }
}
