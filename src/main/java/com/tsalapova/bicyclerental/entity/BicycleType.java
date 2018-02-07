package com.tsalapova.bicyclerental.entity;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public enum BicycleType {
    RROAD, WOMEN, CHILDREN, RACING;

    public String getName(){
        return name().toLowerCase();
    }
}
