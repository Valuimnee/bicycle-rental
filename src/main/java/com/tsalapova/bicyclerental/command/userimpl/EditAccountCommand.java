package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.ActionCommand;
import com.tsalapova.bicyclerental.command.DocumentConstant;
import com.tsalapova.bicyclerental.command.RequestConstant;
import com.tsalapova.bicyclerental.command.SessionConstant;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.UserLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class EditAccountCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute(SessionConstant.LOGIN);
        String newLogin = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        String newPassword = request.getParameter(DocumentConstant.NEW_PASSWORD);
        String newPassword2 = request.getParameter(DocumentConstant.NEW_PASSWORD2);

        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateLogin(newLogin) || !(password.isEmpty() && newPassword.isEmpty() && newPassword2.isEmpty() ||
                validator.validatePassword(password) && validator.validateConfirmPassword(newPassword, newPassword2))) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.ACCOUNT);
            return getStartPage(request);
        }

        try {
            if (new UserLogicImpl().update(login, password, newLogin, newPassword)) {
                session.setAttribute(SessionConstant.LOGIN, newLogin);
                return getStartPage(request);
            } else {
                request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
                request.setAttribute(RequestConstant.CONTENT, RequestConstant.ACCOUNT);
                return getStartPage(request);
            }
        } catch (LogicException e) {
            throw new CommandException("Error while updating user account", e);
        }
    }
}
