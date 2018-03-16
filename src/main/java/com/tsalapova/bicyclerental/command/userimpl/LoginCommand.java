package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.command.UserCommand;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class LoginCommand implements SessionCommand, UserCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        User user = new User();
        if (!defineUser(request, user)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return PageConstant.LOGIN;
        }
        if(!new LogicInjector().getUserLogic().login(user)){
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.BLOCKED);
            return PageConstant.MAIN;
        }
        if (user.getId() != -1L) {
            HttpSession session = request.getSession(true);
            setUserSession(session, user);
            return getStartPage(request);
        } else {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return PageConstant.LOGIN;
        }
    }
}
