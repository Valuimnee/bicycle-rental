package com.tsalapova.bicyclerental.command.clientimpl;

import com.tsalapova.bicyclerental.command.ClientCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.ClientLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class ViewClientsCommand implements ClientCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<List> content;
        try {
            content=new ClientLogicImpl().displayAll();
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
