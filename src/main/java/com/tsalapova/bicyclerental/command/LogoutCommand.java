package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/4/2018
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession(true);
        session.invalidate();
        return PageConstant.MAIN;
    }
}
