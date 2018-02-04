package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.LocationLogicImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class LocationsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Location> locations;
        try {
            locations = new LocationLogicImpl().displayAll();
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying locations.", e);
        }
        if(locations.isEmpty()){
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_LOCATIONS);
        }else{
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.LOCATIONS);
            request.setAttribute(RequestConstant.LOCATIONS, locations);
        }
        return getStartPage(request);
    }
}
