package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Common interface for commands related to user logic.
 * Such as define user.
 *
 * @author TsalapovaMD
 * @version 1.0, 2/12/2018
 */
public interface UserCommand extends ActionCommand {
    /**
     * Method defines existing user.
     * Retrieves user parameters from {@code request}, sets them to user and validates it.
     * Returns result of the validation.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param user    user to be defined
     * @return {@code boolean} - {@code true} if user bicycle is valid, otherwise {@code false}
     */
    default boolean defineUser(HttpServletRequest request, User user) {
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        user.setLogin(login);
        user.setPassword(password);
        return new ParameterValidator().validateUserInfo(user);
    }

    /**
     * Method defines new user.
     * Retrieves user parameters from {@code request}, sets them to user and validates it.
     * Returns result of the validation.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param user    new user to be defined
     * @return {@code boolean} - {@code true} if defined new user is valid, otherwise {@code false}
     */
    default boolean defineNewUser(HttpServletRequest request, User user) {
        String login = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        String password2 = request.getParameter(DocumentConstant.PASSWORD_2);
        ParameterValidator validator = new ParameterValidator();
        user.setLogin(login);
        user.setPassword(password);
        return validator.validateLogin(login) && validator.validateConfirmPassword(password, password2);
    }

    /**
     * Method defines old user information and user information to be updated.
     * Retrieves users parameters from {@code request}, sets them to users and validates them.
     * Returns result of the validation.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param user    old user to be defined
     * @param newUser updated user to be defined
     * @return {@code boolean} - {@code true} if defined user and updated user are valid, otherwise {@code false}
     */
    default boolean defineUpdateUser(HttpServletRequest request, User user, User newUser) {
        String newLogin = request.getParameter(DocumentConstant.LOGIN);
        String password = request.getParameter(DocumentConstant.PASSWORD);
        String newPassword = request.getParameter(DocumentConstant.NEW_PASSWORD);
        String newPassword2 = request.getParameter(DocumentConstant.NEW_PASSWORD2);
        user.setPassword(password);
        newUser.setLogin(newLogin);
        newUser.setPassword(newPassword);
        ParameterValidator validator = new ParameterValidator();
        if (!validator.validateLogin(newLogin) || !(password.isEmpty() && newPassword.isEmpty() && newPassword2.isEmpty() ||
                validator.validatePassword(password) && validator.validateConfirmPassword(newPassword, newPassword2))) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return false;
        }
        return true;
    }
}
