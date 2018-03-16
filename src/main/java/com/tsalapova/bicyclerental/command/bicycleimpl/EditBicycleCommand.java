package com.tsalapova.bicyclerental.command.bicycleimpl;

import com.tsalapova.bicyclerental.command.BicycleCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/10/2018
 */
public class EditBicycleCommand implements BicycleCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession();
        Bicycle bicycle = (Bicycle) session.getAttribute(SessionConstant.BICYCLE);
        if (!defineBicycle(request, bicycle)) {
            setToRequestMaterialsTypes(request);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.BICYCLE);
            return PageConstant.ADMIN;
        }
        BicycleLogic logic = new LogicInjector().getBicycleLogic();
        logic.edit(bicycle);
        removeBicycleFromSession(session);
        return PageConstant.ADMIN;
    }
}
