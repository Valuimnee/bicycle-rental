package com.tsalapova.bicyclerental.command.sessionimpl;

import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/4/2018
 */
public class LogoutCommand implements SessionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        clearUserSession(session);
        return PageConstant.MAIN;
    }
}
