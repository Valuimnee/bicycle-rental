package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RegisterLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class RegisterCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        User user = new User();
        Client client = new Client();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        user.setLogin(login);
        user.setRole("client");

        client.setFirstName(request.getParameter("first-name"));
        client.setMiddleName(request.getParameter("middle-name"));
        client.setLastname(request.getParameter("lastname"));
        client.setAddress(request.getParameter("address"));
        client.setPassportNumber(request.getParameter("passport"));
        client.setPhone(request.getParameter("phone"));
        client.setEmail(request.getParameter("email"));
        client.setActive((byte)1);

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateLogin(login) || !validator.validateConfirmPassword(password, password2) ||
                !validator.validateClientInfo(client)) {
            request.setAttribute("wrong", "wrong-info");
            return PageConstant.REGISTER;
        }
        try {
            if (!new RegisterLogicImpl().register(user, password, client)) {
                request.setAttribute("wrong", "wrong-login");
                return PageConstant.REGISTER;
            }
        } catch (LogicException e) {
            throw new CommandException("Registration error. "+e.getMessage(), e);
        }
        new SessionConstant().setUserSession(session, user);
        return getStartPage(request);
    }
}
