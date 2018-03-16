package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class ViewClientCommand implements ClientCommand {

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        long clientId = Long.valueOf(request.getParameter(DocumentConstant.CLIENT_ID));
        LogicInjector logicInjector = new LogicInjector();
        String login = logicInjector.getUserLogic().findById(clientId).getLogin();
        Client client = logicInjector.getClientLogic().displayProfile(clientId);
        Long rentals = logicInjector.getRentalLogic().countByClientId(clientId);

        request.setAttribute(RequestConstant.LOGIN, login);
        request.setAttribute(RequestConstant.CLIENT, client);
        request.setAttribute(RequestConstant.RENTAL_COUNT, rentals);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CLIENT);
        return PageConstant.ADMIN;
    }
}
