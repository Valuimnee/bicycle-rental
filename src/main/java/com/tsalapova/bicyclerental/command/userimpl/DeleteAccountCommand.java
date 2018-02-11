package com.tsalapova.bicyclerental.command.userimpl;

import com.tsalapova.bicyclerental.command.ActionCommand;
import com.tsalapova.bicyclerental.command.DocumentConstant;
import com.tsalapova.bicyclerental.command.PageConstant;
import com.tsalapova.bicyclerental.command.SessionConstant;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.DeleteAccountLogicImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class DeleteAccountCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        try {
            new DeleteAccountLogicImpl().deleteClient((Long)session.getAttribute(SessionConstant.ID));
        } catch (LogicException e) {
            throw new CommandException("Error occurred on delete account", e);
        }
        Enumeration<String> attributes=session.getAttributeNames();
        String attribute;
        while(attributes.hasMoreElements()){
            attribute=attributes.nextElement();
            if(!attribute.equals(DocumentConstant.LANG)){
                session.removeAttribute(attribute);
            }
        }
        return PageConstant.MAIN;
    }
}
