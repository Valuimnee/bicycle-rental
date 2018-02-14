package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.ActionCommand;
import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/24/2018
 */
public class LanguageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return getStartPage(request);
    }
}
