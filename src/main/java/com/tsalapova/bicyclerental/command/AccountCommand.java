package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface AccountCommand extends ActionCommand {
    default boolean defineAccount(HttpServletRequest request, Account account) {
        Double balance = Double.valueOf(request.getParameter(DocumentConstant.BALANCE));
        account.setBalance(balance);
        return new ParameterValidator().validateAccount(account);
    }
}
