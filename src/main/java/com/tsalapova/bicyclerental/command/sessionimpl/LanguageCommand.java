package com.tsalapova.bicyclerental.command.sessionimpl;

import com.tsalapova.bicyclerental.command.SessionCommand;
import com.tsalapova.bicyclerental.exception.DAOException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/24/2018
 */
public class LanguageCommand implements SessionCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        return getStartPage(request);
    }
}
