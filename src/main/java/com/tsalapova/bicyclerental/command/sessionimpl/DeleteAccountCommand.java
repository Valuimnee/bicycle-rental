package com.tsalapova.bicyclerental.command.sessionimpl;

import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class DeleteAccountCommand implements SessionCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession(true);
        Long clientId = (Long) session.getAttribute(SessionConstant.ID);
        new LogicInjector().getSessionLogic().deleteClient(clientId);
        clearUserSession(session);
        return PageConstant.MAIN;
    }
}
