package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.ClientLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.PageConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class ChangeStatusCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        long clientId = Long.valueOf(request.getParameter(DocumentConstant.CLIENT_ID));
        Byte active = Byte.valueOf(request.getParameter(DocumentConstant.ACTIVE));
        ClientLogic clientLogic = new LogicInjector().getClientLogic();
        clientLogic.changeActiveById(clientId, active);
        return PageConstant.ADMIN;
    }
}
