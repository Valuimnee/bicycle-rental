package com.tsalapova.bicyclerental.command.locationimpl;

import com.tsalapova.bicyclerental.command.LocationCommand;
import com.tsalapova.bicyclerental.exception.DAOException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class LocationsCommand implements LocationCommand {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        return setToRequestLocations(request);
    }
}
