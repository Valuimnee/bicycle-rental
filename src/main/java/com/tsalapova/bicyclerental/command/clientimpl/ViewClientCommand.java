package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.UserLogicImpl;
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
    public String execute(HttpServletRequest request) throws CommandException {
        long clientId = Long.valueOf(request.getParameter(DocumentConstant.CLIENT_ID));
        String login;
        Client client;
        Long rentals;
        try {
            User user=new UserLogicImpl().findById(clientId);
            login=user.getLogin();
            client=new ClientLogicImpl().displayProfile(clientId);
            rentals=new RentalLogicImpl().countByClientId(clientId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying user information", e);
        }
        request.setAttribute(RequestConstant.LOGIN, login);
        request.setAttribute(RequestConstant.CLIENT, client);
        request.setAttribute(RequestConstant.RENTAL_COUNT, rentals);
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CLIENT);
        return PageConstant.ADMIN;
    }
}
