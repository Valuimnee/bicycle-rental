package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The interface, common for all commands.
 * Includes method execute - base method of all command
 *
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public interface ActionCommand {
    /**
     * The main method where execution of all commands happens
     * @param request HttpServletRequest - current request
     * @return String - next page
     * @throws CommandException Exception is thrown if exception on the logic layer appears
     */
    String execute(HttpServletRequest request) throws CommandException;

    /**
     * Method returns the start page depending on the role of the client:
     * user, administrator or unauthorized client
     *
     * @param request HttpServletRequest - current request
     * @return String - start page
     */
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
}
