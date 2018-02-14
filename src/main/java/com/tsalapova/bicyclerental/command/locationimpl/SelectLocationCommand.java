package com.tsalapova.bicyclerental.command.locationimpl;

import com.tsalapova.bicyclerental.command.LocationCommand;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class SelectLocationCommand implements LocationCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(RequestConstant.SELECT, RequestConstant.SELECT);
        return setToRequestLocations(request);
    }
}
