package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface includes common methods for commands related to client logic.
 * For example, define client from request information
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface ClientCommand extends ActionCommand {
    /**
     * Method retrieves client parameters from the request, sets them to client and validates it.
     * If client is valid, returns true.
     * Else sets &Prime;wrong&Prime; attribute to the request and returns false.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param client  client to be defined
     * @return {@code boolean} - {@code true} if defined bicycle is valid, otherwise {@code false}
     */
    default boolean defineClient(HttpServletRequest request, Client client) {
        client.setFirstName(request.getParameter(DocumentConstant.FIRST_NAME));
        client.setMiddleName(request.getParameter(DocumentConstant.MIDDLE_NAME));
        client.setLastname(request.getParameter(DocumentConstant.LASTNAME));
        client.setAddress(request.getParameter(DocumentConstant.ADDRESS));
        client.setPassportNumber(request.getParameter(DocumentConstant.PASSPORT));
        client.setPhone(request.getParameter(DocumentConstant.PHONE));
        client.setEmail(request.getParameter(DocumentConstant.EMAIL));
        client.setActive((byte) 1);
        if (!new ParameterValidator().validateClientInfo(client)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return false;
        }
        return true;
    }

}
