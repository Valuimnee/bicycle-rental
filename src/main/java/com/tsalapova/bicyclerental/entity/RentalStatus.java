package com.tsalapova.bicyclerental.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/6/2018
 */
public enum RentalStatus {
    CONCLUDED, PERFORMED, CANCELED;

    public String getName() {
        return StringUtils.capitalize(name().toLowerCase());
    }
}