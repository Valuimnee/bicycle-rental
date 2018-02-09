package com.tsalapova.bicyclerental.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/8/2018
 */
public enum BicycleMaterial {
    STEEL, ALUMINIUM, CARBON_FIBRE, TITANIUM, MAGNESIUM;

    public String getName(){
        return StringUtils.capitalize(name().toLowerCase().replace('_', ' '));
    }

    public String getAttributeName(){
        return name().toLowerCase().replace('_', '-');
    }

    public static BicycleMaterial defineMaterial(String attributeName){
        return BicycleMaterial.valueOf(attributeName.replace('-', '_').toUpperCase());
    }
}
