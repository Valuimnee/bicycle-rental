package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.ActionCommand;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class UserAccountCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.USER_ACCOUNT);
        return getStartPage(request);
    }
}
