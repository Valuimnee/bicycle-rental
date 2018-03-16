package com.tsalapova.bicyclerental.command.accountimpl;


import com.tsalapova.bicyclerental.command.AccountCommand;
import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.AccountLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class ViewBalanceCommand implements AccountCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession();
        long clientId = (Long) session.getAttribute(SessionConstant.ID);
        Account account;
        AccountLogic logic = new LogicInjector().getAccountLogic();
        account = logic.findByClientId(clientId);
        if (account != null) {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.ACCOUNT);
            request.setAttribute(RequestConstant.ACCOUNT, account);
        } else {
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_ACCOUNT);
        }
        return PageConstant.MAIN;

    }
}
