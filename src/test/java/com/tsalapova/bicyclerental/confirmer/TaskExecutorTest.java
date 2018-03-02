package com.tsalapova.bicyclerental.confirmer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class TaskExecutorTest {
    @Test
    public void testSetupDatabaseRentals() throws Exception {
        TaskExecutor.getInstance().setupInitialRentals();
        Thread.sleep(2000);
        HashMap map= TaskExecutor.getInstance().getTasks();
        System.out.println(map.keySet());
        Assert.assertNull((ScheduledFuture)map.get(0));
    }

}