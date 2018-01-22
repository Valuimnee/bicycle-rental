package com.tsalapova.bicyclerental.db;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/2/2018
 */
public class ConnectionPoolTest {

    @Test
    public void testGetInstance() throws Exception {
        Assert.assertTrue(null != ConnectionPool.getInstance());
    }

    @Test
    public void testGetConnection() throws Exception {
        Assert.assertTrue(null != ConnectionPool.getInstance().getConnection());
    }
}