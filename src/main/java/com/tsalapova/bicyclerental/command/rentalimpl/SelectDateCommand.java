package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.entity.RentalStatus;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.util.EntityAction;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class SelectDateCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
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
        request.setAttribute(RequestConstant.DATETIME, new EntityAction().defineDateTime(rental.getStartTime()));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CONFIRM_RENTAL);
        return PageConstant.MAIN;
    }

}
