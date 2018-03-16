package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.UserCommand;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class EditAccountCommand implements UserCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute(SessionConstant.LOGIN);
        User user = new User();
        User newUser = new User();
        if (!defineUpdateUser(request, user, newUser)) {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.USER_ACCOUNT);
            return getStartPage(request);
        }
        user.setLogin(login);
        if (new LogicInjector().getUserLogic().update(user, newUser)) {
            session.setAttribute(SessionConstant.LOGIN, newUser.getLogin());
        } else {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.USER_ACCOUNT);
        }
        return getStartPage(request);
    }

}
