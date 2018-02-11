package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.DocumentConstant;
import com.tsalapova.bicyclerental.command.PageConstant;
import com.tsalapova.bicyclerental.command.RequestConstant;
import com.tsalapova.bicyclerental.command.UserCommand;
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
public class LoginCommand implements UserCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);

        ParameterValidator validator=new ParameterValidator();
        if(!validator.validateLogin(login)||!validator.validatePassword(password)){
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return PageConstant.LOGIN;
        }

        User user;
        try {
            user = new UserLogicImpl().login(login, password);
        } catch (LogicException e) {
            throw new CommandException("Error while logging in", e);
        }
        if (user != null) {
            HttpSession session = request.getSession(true);
            setUserSession(session,user);
            return getStartPage(request);
        } else {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return PageConstant.LOGIN;
        }
    }
}
