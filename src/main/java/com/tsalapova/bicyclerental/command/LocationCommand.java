package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.impl.LocationLogicImpl;
import com.tsalapova.bicyclerental.util.RequestConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The interface includes common methods for commands, related to location logic,
 * such as setting locations to request
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface LocationCommand extends ActionCommand {
    /**
     * Method selects all locations from the logic layer.
     * If no locations were selected, sets message to the request.
     * Otherwise sets locations to the request.
     * Returns user main page
     *
     * @param request {@code HttpServletRequest} - current request
     * @return {@code String} - user main page
     * @throws DAOException thrown if exception appears when retrieving locations
     */
    default String setToRequestLocations(HttpServletRequest request) throws DAOException {
        List<Location> locations = new LocationLogicImpl().displayAll();
        if (locations.isEmpty()) {
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_LOCATIONS);
        } else {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.LOCATIONS);
            request.setAttribute(RequestConstant.LOCATIONS, locations);
        }
        return getStartPage(request);
    }
}
