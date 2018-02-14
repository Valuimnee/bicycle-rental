package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.util.*;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * The interface includes methods, common for several rental commands,
 * such as displaying rentals, defining rental&apos;s parameters.
 * Base interface for all commands, working with rentals
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface RentalCommand extends ActionCommand {
    /**
     * Methods sets lists of rentals and corresponding bicycles to request.
     * If rental list is empty, sets message to request.
     * Returns page where to send request and response
     *
     * @param rentals  List of rentals to display
     * @param bicycles List bicycles corresponding to rentals to display
     * @param request  HttpServletRequest - current request
     * @param message  Message to display if there are no rentals
     * @return String - next page
     */
    default String setToRequestRentals(List<Rental> rentals, List<Bicycle> bicycles, HttpServletRequest request, String message) {
        if (rentals.isEmpty()) {
            request.setAttribute(RequestConstant.MESSAGE, message);
            return PageConstant.MAIN;
        }
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTALS);
        request.setAttribute(RequestConstant.RENTALS, rentals);
        request.setAttribute(RequestConstant.BICYCLES, bicycles);
        return PageConstant.MAIN;
    }

    /**
     * Method retrieves start date and hours from the request, validates them.
     * In case they are valid, sets start date and hours to rental, recalculates the total of the rental
     * and returns true.
     * Otherwise sets &Prime;wrong&Prime; attribute to the request and returns false.
     *
     * @param request HttpServletRequest - current request
     * @param rental  current rental
     * @return boolean - true if the defined start date and hours are valid, else false
     */
    default boolean defineDateHours(HttpServletRequest request, Rental rental) {
        HttpSession session = request.getSession();
        Timestamp startDate = new EntityAction().defineTimestamp(request.getParameter(DocumentConstant.START_DATE));
        int hours = Integer.valueOf(request.getParameter(DocumentConstant.HOURS));
        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateStartTime(startDate) || !validator.validateHours(hours)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return false;
        }
        rental.setStartTime(startDate);
        if (rental.getHours() != hours) {
            Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
            rental.setHours(hours);
            rental.setTotal(new EntityAction().countTotal(bicycle.getPricePh(), hours));
        }
        return true;
    }

    /**
     * Method removes rental and corresponding bicycle and location attributes from session
     *
     * @param session - current session
     */
    default void removeRentalFromSession(HttpSession session) {
        session.removeAttribute(SessionConstant.LOCATION);
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.RENTAL);
    }
}
