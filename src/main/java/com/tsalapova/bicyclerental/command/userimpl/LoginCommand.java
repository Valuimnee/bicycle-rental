package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.UserLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class LoginCommand implements SessionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user=new User();
        if(!defineUser(request, user)){
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG);
            return PageConstant.LOGIN;
        }

        try {
            user = new UserLogicImpl().login(user);
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

    private boolean defineUser(HttpServletRequest request, User user){
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);

        ParameterValidator validator=new ParameterValidator();
        if(!validator.validateLogin(login)||!validator.validatePassword(password)){
            return false;
        }

        user.setLogin(login);
        user.setPassword(password);
        return true;
    }
}
