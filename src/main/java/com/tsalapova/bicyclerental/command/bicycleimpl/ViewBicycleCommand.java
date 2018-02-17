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
 * @version 1.0, 2/10/2018
 */
public class ViewBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Pair<Bicycle, Location> pair = selectBicycle(request);
        if (pair.getKey() == null) {
            return PageConstant.ADMIN;
        }

        session.setAttribute(SessionConstant.BICYCLE, pair.getKey());
        session.setAttribute(SessionConstant.LOCATION, pair.getValue());

        setToRequestMaterialsTypes(request);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.BICYCLE);
        return PageConstant.ADMIN;
    }
}
