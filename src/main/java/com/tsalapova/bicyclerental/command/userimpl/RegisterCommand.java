package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.*;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
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
public class RegisterCommand implements UserCommand, ClientCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        User user = new User();
        Client client = new Client();
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        String password2 = request.getParameter(DocumentConstant.PASSWORD_2);

        user.setLogin(login);
        user.setRole(UserRole.CLIENT.getName());

        client.setFirstName(request.getParameter(DocumentConstant.FIRST_NAME));
        client.setMiddleName(request.getParameter(DocumentConstant.MIDDLE_NAME));
        client.setLastname(request.getParameter(DocumentConstant.LASTNAME));
        client.setAddress(request.getParameter(DocumentConstant.ADDRESS));
        client.setPassportNumber(request.getParameter(DocumentConstant.PASSPORT));
        client.setPhone(request.getParameter(DocumentConstant.PHONE));
        client.setEmail(request.getParameter(DocumentConstant.EMAIL));
        client.setActive((byte)1);

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateLogin(login) || !validator.validateConfirmPassword(password, password2) ||
                !validator.validateClientInfo(client)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return PageConstant.REGISTER;
        }
        try {
            if (!new RegisterLogicImpl().register(user, password, client)) {
                request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_LOGIN);
                return PageConstant.REGISTER;
            }
        } catch (LogicException e) {
            throw new CommandException("Registration error. "+e.getMessage(), e);
        }
        setUserSession(session, user);
        return getStartPage(request);
    }
}
