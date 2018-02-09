package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.BicycleMaterial;
import com.tsalapova.bicyclerental.entity.BicycleType;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class AddBicycleFormCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.ADD_BICYCLE);
        request.setAttribute(RequestConstant.MATERIALS,
                Stream.of(BicycleMaterial.values()).map(material -> material.getAttributeName()).toArray(String[]::new));
        request.setAttribute(RequestConstant.TYPES,
                Stream.of(BicycleType.values()).map(type -> type.getName()).toArray(String[]::new));
        return PageConstant.ADMIN;
    }
}
