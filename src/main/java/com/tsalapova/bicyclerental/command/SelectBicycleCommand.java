package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.LocationLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/6/2018
 */
public class SelectBicycleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        long bicycleId=Long.valueOf(request.getParameter(DocumentConstant.BICYCLE_ID));
        Location location;
        Bicycle bicycle;

        try {
            bicycle=new BicycleLogicImpl().displayById(bicycleId);
            if(bicycle==null){
                return PageConstant.MAIN;
            }
            location=new LocationLogicImpl().displayById(bicycle.getLocationId());
            if(location==null){
                return PageConstant.MAIN;
            }
        } catch (LogicException e) {
            throw new CommandException("Error occurred when renting bike", e);
        }

        session.setAttribute(SessionConstant.BICYCLE, bicycle);
        session.setAttribute(SessionConstant.LOCATION, location);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.DATE);
        return PageConstant.MAIN;
    }
}
