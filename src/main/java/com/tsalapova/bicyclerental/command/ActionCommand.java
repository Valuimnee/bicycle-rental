package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public interface ActionCommand {
    String execute(HttpServletRequest request) throws CommandException;

    default String getStartPage(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String role = (String) session.getAttribute(SessionConstant.ROLE);
        if (role == null) {
            return PageConstant.MAIN;
        }
        SessionConstant.ROLE_NAME roleName = SessionConstant.ROLE_NAME.valueOf(role.toUpperCase());
        switch (roleName) {
            case ADMINISTRATOR: {
                return PageConstant.ADMIN;
            }
            case USER:
            default: {
                return PageConstant.MAIN;
            }
        }
    }

    //TODO
    //Logging
    //PageConstant
    //final
    //parameters in constant
}
