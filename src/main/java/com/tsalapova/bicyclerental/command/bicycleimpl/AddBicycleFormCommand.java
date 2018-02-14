package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class AddBicycleFormCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        setToRequestMaterialsTypes(request);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.ADD_BICYCLE);
        return PageConstant.ADMIN;
    }
}
