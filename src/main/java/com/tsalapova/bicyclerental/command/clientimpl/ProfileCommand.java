package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class ProfileCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        Client client;
        try {
            client=new ClientLogicImpl().displayProfile((Long) session.getAttribute(SessionConstant.ID));
        } catch (LogicException e) {
            throw new CommandException("Error occurred while displaying profile", e);
        }
        if(client!=null){
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.PROFILE);
            session.setAttribute(RequestConstant.CLIENT, client);
        }else{
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_PROFILE);
        }
        return PageConstant.MAIN;
    }
}
