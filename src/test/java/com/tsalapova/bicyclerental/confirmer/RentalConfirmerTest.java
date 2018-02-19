package com.tsalapova.bicyclerental.confirmer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class RentalConfirmerTest {
    @Test
    public void testSetupDatabaseRentals() throws Exception {
        RentalConfirmer.getInstance().setupDatabaseRentals();
        Thread.sleep(2000);
        HashMap map=RentalConfirmer.getInstance().getTasks();
        System.out.println(map.keySet());
        Assert.assertNull((ScheduledFuture)map.get(0));
    }

}