package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.CommandException;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/6/2018
 */
public class SelectBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Pair<Bicycle, Location> pair = selectBicycle(request);
        if (pair.getKey() == null || pair.getValue() == null) {
            return PageConstant.MAIN;
        }
        session.setAttribute(SessionConstant.BICYCLE, pair.getKey());
        session.setAttribute(SessionConstant.LOCATION, pair.getValue());
        session.removeAttribute(SessionConstant.RENTAL);

        request.setAttribute(RequestConstant.CONTENT, RequestConstant.DATE);
        return PageConstant.MAIN;
    }
}
