package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.BicycleMaterial;
import com.tsalapova.bicyclerental.entity.BicycleType;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.CommandException;
import com.tsalapova.bicyclerental.exception.LogicException;
import com.tsalapova.bicyclerental.logic.impl.BicycleLogicImpl;
import com.tsalapova.bicyclerental.logic.impl.LocationLogicImpl;
import com.tsalapova.bicyclerental.validator.ParameterValidator;
import javafx.util.Pair;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Stream;

/**
 * The interface includes common methods for some commands related to bicycle logic.
 * Such as define bicycle, set list of bicycle to the request, retrieve bicycle
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
     * @return String - next page
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
    default void setMaterialsTypes(HttpServletRequest request) {
        request.setAttribute(RequestConstant.MATERIALS,
                Stream.of(BicycleMaterial.values()).map(BicycleMaterial::getAttributeName).toArray(String[]::new));
        request.setAttribute(RequestConstant.TYPES,
                Stream.of(BicycleType.values()).map(BicycleType::getName).toArray(String[]::new));
    }

    /**
     * Method retrieves bicycle parameters from the request, updates bicycle and validates it.
     * If bicycle is valid, returns true.
     * Else sets &Prime;wrong&Prime; attribute to the request and returns false.
     *
     * @param request HttpServletRequest - current request
     * @return Bicycle - defined bicycle or null
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
     * @param request HttpServletRequest - current request
     * @return Pair - pair of bicycle and corresponding location
     * @throws CommandException thrown if exception appears when retrieving bicycle and location
     */
    default Pair<Bicycle, Location> selectBicycle(HttpServletRequest request) throws CommandException {
        long bicycleId = Long.valueOf(request.getParameter(DocumentConstant.BICYCLE_ID));
        Bicycle bicycle;
        Location location = null;

        try {
            bicycle = new BicycleLogicImpl().displayById(bicycleId);
            if (bicycle != null) {
                location = new LocationLogicImpl().displayById(bicycle.getLocationId());
            }
        } catch (LogicException e) {
            throw new CommandException("Error occurred when selecting bike", e);
        }
        return new Pair<>(bicycle, location);
    }
}
