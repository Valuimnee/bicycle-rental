package com.tsalapova.bicyclerental.command.rentalimpl;

import com.tsalapova.bicyclerental.command.RentalCommand;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.LogicInjector;
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
public class ClientRentalsCommand implements RentalCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        HttpSession session = request.getSession();
        long clientId = (Long) session.getAttribute(SessionConstant.ID);
        Pair<List<Rental>, List<Bicycle>> pair = new LogicInjector().getRentalLogic().displayByClientId(clientId);
        return setToRequestRentals(pair.getKey(), pair.getValue(), request, RequestConstant.NO_RENTALS);
    }
}
