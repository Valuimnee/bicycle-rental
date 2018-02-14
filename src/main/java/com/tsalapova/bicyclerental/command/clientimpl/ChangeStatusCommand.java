package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.util.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class ChangeStatusCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        long clientId = Long.valueOf(request.getParameter(DocumentConstant.CLIENT_ID));
        Byte active = Byte.valueOf(request.getParameter(DocumentConstant.ACTIVE));
        try {
            new ClientLogicImpl().changeActiveById(clientId, active);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when changing client status", e);
        }
        return PageConstant.ADMIN;
    }
}
