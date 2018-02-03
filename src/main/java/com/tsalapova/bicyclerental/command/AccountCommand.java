package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class AccountCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.ACCOUNT);
        return getStartPage(request);
    }
}
