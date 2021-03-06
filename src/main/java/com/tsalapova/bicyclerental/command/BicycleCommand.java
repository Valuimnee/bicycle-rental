package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.BicycleMaterial;
import com.tsalapova.bicyclerental.entity.BicycleType;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.logic.BicycleLogic;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.RequestConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;
import com.tsalapova.bicyclerental.validator.ParameterValidator;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Stream;

/**
 * The interface includes common methods for commands related to bicycle logic.
 * Such as define bicycle, set list of bicycle to the request,
 * retrieve bicycle from logic layer
 *
 * @author TsalapovaMD
 * @version 1.0, 2/10/2018
 */
public interface BicycleCommand extends ActionCommand {
    /**
     * Methods sets lists of bicycles to request.
     * If rental list is empty, sets message to request.
     * Returns page where to send request and response
     *
     * @param bicycles List of bicycles to display
     * @param request  HttpServletRequest - current request
     * @return {@code String} - next page
     */
    default String setToRequestBicycles(List<Bicycle> bicycles, HttpServletRequest request) {
        if (bicycles.isEmpty()) {
            request.setAttribute(RequestConstant.MESSAGE, RequestConstant.NO_BICYCLES);
        } else {
            request.setAttribute(RequestConstant.CONTENT, RequestConstant.BICYCLES);
            request.setAttribute(RequestConstant.BICYCLES, bicycles);
        }
        return getStartPage(request);
    }

    /**
     * Method sets lists of keys for supported materials and types of bicycle to the request
     * for displaying in the select option
     *
     * @param request HttpServletRequest - current request
     */
    default void setToRequestMaterialsTypes(HttpServletRequest request) {
        request.setAttribute(RequestConstant.MATERIALS,
                Stream.of(BicycleMaterial.values()).map(BicycleMaterial::getAttributeName).toArray(String[]::new));
        request.setAttribute(RequestConstant.TYPES,
                Stream.of(BicycleType.values()).map(BicycleType::getName).toArray(String[]::new));
    }

    /**
     * Method removes bicycle and corresponding location attributes from session
     *
     * @param session current session
     */
    default void removeBicycleFromSession(HttpSession session) {
        session.removeAttribute(SessionConstant.BICYCLE);
        session.removeAttribute(SessionConstant.LOCATION);
    }

    /**
     * Method retrieves bicycle parameters from the request, updates bicycle and validates it.
     * If bicycle is valid, returns true.
     * Else sets &Prime;wrong&Prime; attribute to the request and returns false.
     *
     * @param request {@code HttpServletRequest} - current request
     * @param bicycle bicycle to be defined
     * @return {@code boolean} - {@code true} if defined bicycle is valid, otherwise {@code false}
     */
    default boolean defineBicycle(HttpServletRequest request, Bicycle bicycle) {
        String model = request.getParameter(DocumentConstant.MODEL);
        String brand = request.getParameter(DocumentConstant.BRAND);
        String attributeMaterial = request.getParameter(DocumentConstant.MATERIAL);
        String material = BicycleMaterial.defineMaterial(attributeMaterial).getName();
        String type = BicycleType.valueOf(request.getParameter(DocumentConstant.TYPE).toUpperCase()).getName();
        Double pricePh = Double.valueOf(request.getParameter(DocumentConstant.PRICE_PH));
        bicycle.setBrand(brand);
        bicycle.setModel(model);
        bicycle.setMaterial(material);
        bicycle.setType(type);
        bicycle.setPricePh(pricePh);
        if (!new ParameterValidator().validateBicycle(bicycle)) {
            request.setAttribute(RequestConstant.WRONG, RequestConstant.WRONG_INFO);
            return false;
        }
        return true;
    }

    /**
     * Method selects bicycle and corresponding location from the logic layer using the request parameter.
     * If no bicycle is found returns pair of nulls.
     *
     * @param request {@code HttpServletRequest} - current request
     * @return {@code javafx.util.Pair} - pair of bicycle and corresponding location
     * @throws DAOException thrown if exception appears when retrieving bicycle and location
     */
    default Pair<Bicycle, Location> selectBicycle(HttpServletRequest request) throws DAOException {
        long bicycleId = Long.valueOf(request.getParameter(DocumentConstant.BICYCLE_ID));
        Bicycle bicycle;
        Location location = null;
        BicycleLogic logic=new LogicInjector().getBicycleLogic();
        bicycle = logic.displayById(bicycleId);
        if (bicycle != null) {
            location = new LogicInjector().getLocationLogic().displayById(bicycle.getLocationId());
        }
        return new Pair<>(bicycle, location);
    }
}
