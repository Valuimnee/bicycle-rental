package com.tsalapova.bicyclerental.util;

import java.sql.Timestamp;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/7/2018
 */
public class EntityAction {
    private final static int DAY = 24;
    private final static double PRICE_COEFFICIENT = 4.;

    public Timestamp defineTimestamp(String datetime){
        return Timestamp.valueOf(datetime.replace('T', ' ').concat(":00"));
    }

    public String defineDateTime(Timestamp timestamp){
        return timestamp.toString().replace(' ', 'T')
                .substring(0, timestamp.toString().lastIndexOf(':'));
    }

    public double countTotal(double pricePh, int hours) {
        if (hours < DAY) {
            return pricePh * hours;
        } else {
            return pricePh * PRICE_COEFFICIENT * hours / DAY;
        }
    }
}
