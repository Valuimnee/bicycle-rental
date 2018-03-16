package com.tsalapova.bicyclerental.command.sessionimpl;

import com.tsalapova.bicyclerental.command.AccountCommand;
import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.command.UserCommand;
import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class RegisterCommand implements SessionCommand, UserCommand, ClientCommand, AccountCommand {

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession(true);
        User user = new User();
        Client client = new Client();
        Account account = new Account();
        if (!defineNewUser(request, user) || !defineClient(request, client) || !defineAccount(request, account)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return PageConstant.REGISTER;
        }
        user.setRole(UserRole.CLIENT.getName());
        if (!new LogicInjector().getSessionLogic().register(user, user.getPassword(), client, account)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_LOGIN);
            return PageConstant.REGISTER;
        }
        setUserSession(session, user);
        return getStartPage(request);
    }

}
