package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.ClientLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class ViewClientsCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<List> content;
        ClientLogic clientLogic = new LogicInjector().getClientLogic();
        try {
            content = clientLogic.displayAll();
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying user rentals", e);
        }
        request.setAttribute(RequestConstant.LOGINS, content.get(0));
        request.setAttribute(RequestConstant.CLIENTS, content.get(1));
        request.setAttribute(RequestConstant.RENTALS, content.get(2));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.CLIENTS);
        return PageConstant.ADMIN;
    }
}
