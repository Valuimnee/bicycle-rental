package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.*;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class EditProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        Client newClient=new Client();
        newClient.setClientId((Long)session.getAttribute(SessionConstant.ID));
        newClient.setFirstName(request.getParameter(DocumentConstant.FIRST_NAME));
        newClient.setMiddleName(request.getParameter(DocumentConstant.MIDDLE_NAME));
        newClient.setLastname(request.getParameter(DocumentConstant.LASTNAME));
        newClient.setAddress(request.getParameter(DocumentConstant.ADDRESS));
        newClient.setPassportNumber(request.getParameter(DocumentConstant.PASSPORT));
        newClient.setPhone(request.getParameter(DocumentConstant.PHONE));
        newClient.setEmail(request.getParameter(DocumentConstant.EMAIL));
        newClient.setActive((byte)1);

        if(!new ParameterValidator().validateClientInfo(newClient)){
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.PROFILE);
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return PageConstant.MAIN;
        }

        try {
            new ClientLogicImpl().update(newClient);
        } catch (LogicException e) {
            throw new CommandException("Error while updating client information", e);
        }
        return PageConstant.MAIN;
    }
}
