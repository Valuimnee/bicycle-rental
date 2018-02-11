package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.*;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.entity.RentalStatus;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.EntityAction;
import com.tsalapova.bicyclerental.validator.ParameterValidator;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class SelectDateCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Rental rental = new Rental();
        if (!defineDateHours(request, rental)) {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.DATE);
            return PageConstant.MAIN;
        }
        Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
        long clientId = (Long) session.getAttribute(SessionConstant.ID);

        rental.setClientId(clientId);
        rental.setBicycleId(bicycle.getBicycleId());
        rental.setStatus(RentalStatus.CONCLUDED.getName());

        session.setAttribute(SessionConstant.RENTAL, rental);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CONFIRM_RENTAL);
        return PageConstant.MAIN;
    }

}
