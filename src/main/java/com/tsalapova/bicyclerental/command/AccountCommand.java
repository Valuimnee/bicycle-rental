package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface includes common methods for commands related to account logic.
 * Such as define account
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface AccountCommand extends ActionCommand {
    /**
     * Method retrieves account parameters from the request, sets them to {@code account} and validates it.
     * If account is valid, returns true, else false.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param account account to be defined
     * @return {@code boolean} - {@code true} if defined bicycle is valid, otherwise {@code false}
     */
    default boolean defineAccount(HttpServletRequest request, Account account) {
        Double balance = Double.valueOf(request.getParameter(DocumentConstant.BALANCE));
        account.setBalance(balance);
        return new ParameterValidator().validateAccount(account);
    }
}
