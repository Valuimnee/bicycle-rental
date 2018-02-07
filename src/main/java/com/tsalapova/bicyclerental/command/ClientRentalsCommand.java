package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class ClientRentalsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session=request.getSession();
        long clientId=(Long)session.getAttribute(SessionConstant.ID);

        List<Rental> rentals;
        List<Bicycle> bicycles;
        try {
            Pair<List<Rental>, List<Bicycle>> pair=new RentalLogicImpl().displayByClientId(clientId);
            rentals=pair.getKey();
            bicycles=pair.getValue();
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying user rentals", e);
        }
        if(rentals.isEmpty()){
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_RENTALS);
            return PageConstant.MAIN;
        }
        request.setAttribute(RequestConstant.CONTENT, RequestConstant.RENTALS);
        request.setAttribute(RequestConstant.RENTALS, rentals);
        request.setAttribute(RequestConstant.BICYCLES, bicycles);
        return PageConstant.MAIN;
    }
}
