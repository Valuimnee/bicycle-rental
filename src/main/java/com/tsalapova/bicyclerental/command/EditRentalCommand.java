package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.*;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.EntityAction;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class EditRentalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Rental rental;
        EntityAction action=new EntityAction();
        Timestamp timestamp = action.defineTimestamp(request.getParameter(DocumentConstant.START_DATE));
        int hours = Integer.valueOf(request.getParameter(DocumentConstant.HOURS));

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateStartTime(timestamp) || !validator.validateHours(hours)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTAL);
            return PageConstant.MAIN;
        }

        Location location = (Location) session.getAttribute(SessionConstant.LOCATION);
        Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
        long clientId = (Long) session.getAttribute(SessionConstant.ID);

        rental = new Rental();
        rental.setClientId(clientId);
        rental.setBicycleId(bicycle.getBicycleId());
        rental.setStartTime(timestamp);
        rental.setHours(hours);
        rental.setTotal(action.countTotal(bicycle.getPricePh(), hours));
        rental.setStatus(RentalStatus.CONCLUDED.getName());

        session.setAttribute(SessionConstant.RENTAL, rental);

        request.setAttribute(RequestConstant.LOCATION, location);
        request.setAttribute(RequestConstant.BICYCLE, bicycle);
        request.setAttribute(RequestConstant.RENTAL, rental);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CONFIRM_RENTAL);
        return PageConstant.MAIN;
    }
}
