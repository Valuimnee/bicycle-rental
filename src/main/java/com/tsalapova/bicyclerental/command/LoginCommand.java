package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.UserLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class LoginCommand implements ActionCommand {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String WRONG = "wrong";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        ParameterValidator validator=new ParameterValidator();
        if(!validator.validateLogin(login)||!validator.validatePassword(password)){
            request.setAttribute(WRONG, "Invalid login or password, please try again");
            return PageConstant.LOGIN;
        }
        User user;
        try {
            user = new UserLogicImpl().login(login, password);
        } catch (LogicException e) {
            throw new CommandException("Error while logging in.", e);
        }
        if (user != null) {
            HttpSession session = request.getSession(true);
            new SessionConstant().setUserSession(session,user);
            return getStartPage(request);
        } else {
            request.setAttribute(WRONG, "Invalid login or password, please try again");
            return PageConstant.LOGIN;
        }
    }
}
