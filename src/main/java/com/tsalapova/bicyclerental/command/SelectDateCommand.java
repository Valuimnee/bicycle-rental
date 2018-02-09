package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.entity.RentalStatus;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.EntityAction;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class SelectDateCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        EntityAction action=new EntityAction();
        Timestamp timestamp = action.defineTimestamp(request.getParameter(DocumentConstant.START_DATE));
        int hours = Integer.valueOf(request.getParameter(DocumentConstant.HOURS));

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateStartTime(timestamp) || !validator.validateHours(hours)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.DATE);
            return PageConstant.MAIN;
        }

        Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
        long clientId = (Long) session.getAttribute(SessionConstant.ID);

        Rental rental = new Rental();
        rental.setClientId(clientId);
        rental.setBicycleId(bicycle.getBicycleId());
        rental.setStartTime(timestamp);
        rental.setHours(hours);
        rental.setTotal(action.countTotal(bicycle.getPricePh(), hours));
        rental.setStatus(RentalStatus.CONCLUDED.getName());

        session.setAttribute(SessionConstant.RENTAL, rental);

        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CONFIRM_RENTAL);
        return PageConstant.MAIN;
    }

}
