package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.UserCommand;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class UserAccountCommand implements UserCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.USER_ACCOUNT);
        return getStartPage(request);
    }
}
