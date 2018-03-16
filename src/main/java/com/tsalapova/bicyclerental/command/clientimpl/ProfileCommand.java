package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.DAOException;
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
public class ProfileCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession(true);
        Client client;
        ClientLogic clientLogic = new LogicInjector().getClientLogic();
        client = clientLogic.displayProfile((Long) session.getAttribute(SessionConstant.ID));
        if (client != null) {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.PROFILE);
            session.setAttribute(RequestConstant.CLIENT, client);
        } else {
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_PROFILE);
        }
        return PageConstant.MAIN;
    }
}
