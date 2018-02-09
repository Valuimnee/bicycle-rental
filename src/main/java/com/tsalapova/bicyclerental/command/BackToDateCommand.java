package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.util.EntityAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public class BackToDateCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        Rental rental=(Rental)session.getAttribute(SessionConstant.RENTAL);
        request.setAttribute(RequestConstant.DATETIME, new EntityAction().defineDateTime(rental.getStartTime()));
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.DATE);
        return PageConstant.MAIN;
    }
}
