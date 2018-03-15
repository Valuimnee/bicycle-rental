package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.ClientLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class EditProfileCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Client newClient = new Client();
        newClient.setClientId((Long) session.getAttribute(SessionConstant.ID));
        if (!defineClient(request, newClient)) {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.PROFILE);
            return PageConstant.MAIN;
        }
        ClientLogic clientLogic = new LogicInjector().getClientLogic();
        try {
            clientLogic.update(newClient);
        } catch (LogicException e) {
            throw new CommandException("Error while updating client information", e);
        }
        return PageConstant.MAIN;
    }
}
