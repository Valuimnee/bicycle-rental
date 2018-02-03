package com.tsalapova.bicyclerental.entity;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public enum UserRole {
    ADMIN, CLIENT;

    public String getName(){
        return name().toLowerCase();
    }
}
