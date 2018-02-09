package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.BicycleMaterial;
import com.tsalapova.bicyclerental.entity.BicycleType;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class AddBicycleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        String model=request.getParameter(DocumentConstant.MODEL);
        String brand=request.getParameter(DocumentConstant.BRAND);
        String attributeMaterial= request.getParameter(DocumentConstant.MATERIAL);
        String material= BicycleMaterial.defineMaterial(attributeMaterial).getName();
        String type= BicycleType.valueOf(request.getParameter(DocumentConstant.TYPE).toUpperCase()).getName();
        Double pricePh=Double.valueOf(request.getParameter(DocumentConstant.PRICE_PH));
        System.err.println(pricePh);
        Bicycle bicycle=new Bicycle(-1L, -1L, brand, model, material, type, pricePh);
        System.err.println(bicycle);
        if(!new ParameterValidator().validateBicycle(bicycle)){
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.ADD_BICYCLE);
            return PageConstant.ADMIN;
        }

        try {
            new BicycleLogicImpl().add(bicycle);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when adding the bike", e);
        }
        return PageConstant.ADMIN;
    }
}
