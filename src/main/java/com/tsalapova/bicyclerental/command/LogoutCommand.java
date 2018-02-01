package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/4/2018
 */
public class LogoutCommand implements ActionCommand {
    private static final String LANG = "lang";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(true);
        Enumeration<String> attributes=session.getAttributeNames();
        String attribute;
        while(attributes.hasMoreElements()){
            attribute=attributes.nextElement();
            if(!attribute.equals(LANG)){
                session.removeAttribute(attribute);
            }
        }
        return PageConstant.MAIN;
    }
}
