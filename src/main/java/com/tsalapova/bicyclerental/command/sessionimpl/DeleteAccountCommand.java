package com.tsalapova.bicyclerental.command.sessionimpl;

import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.SessionLogicImpl;
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
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        Long clientId = (Long) session.getAttribute(SessionConstant.ID);
        try {
            new SessionLogicImpl().deleteClient(clientId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred on delete account", e);
        }
        clearUserSession(session);
        return PageConstant.MAIN;
    }
}
