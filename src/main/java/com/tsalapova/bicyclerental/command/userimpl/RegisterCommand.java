package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.*;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RegisterLogicImpl;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class RegisterCommand implements SessionCommand, ClientCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        User user = new User();
        Client client = new Client();
        if (!defineUser(request, user) || !defineClient(request, client)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return PageConstant.REGISTER;
        }
        try {
            if (!new RegisterLogicImpl().register(user, user.getPassword(), client)) {
                request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_LOGIN);
                return PageConstant.REGISTER;
            }
        } catch (LogicException e) {
            throw new CommandException("Registration error. "+e.getMessage(), e);
        }
        setUserSession(session, user);
        return getStartPage(request);
    }

    private boolean defineUser(HttpServletRequest request, User user){
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        String password2 = request.getParameter(DocumentConstant.PASSWORD_2);
        ParameterValidator validator = new ParameterValidator();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(UserRole.CLIENT.getName());
        return validator.validateLogin(login) && validator.validateConfirmPassword(password, password2);
    }
}
