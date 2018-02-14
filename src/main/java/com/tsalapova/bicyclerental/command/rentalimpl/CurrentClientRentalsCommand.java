package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
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
 * @version 1.0, 2/8/2018
 */
public class CurrentClientRentalsCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        long clientId = (Long) session.getAttribute(SessionConstant.ID);
        Pair<List<Rental>, List<Bicycle>> pair;

        try {
            pair = new RentalLogicImpl().displayCurrentByClientId(clientId);
        } catch (LogicException e) {
            throw new CommandException("Error occurred when displaying current user rentals", e);
        }

        return setToRequestRentals(pair.getKey(), pair.getValue(), request, RequestConstant.NO_CURRENT_RENTALS);
    }
}
