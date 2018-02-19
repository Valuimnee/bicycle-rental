package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.logic.impl.RentalLogicImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class ConfirmTaskTest {
    @Test
    public void testRun() throws Exception {
        Rental rental;
        List<Entity> entities = new RentalLogicImpl().displayById(2);
        rental = (Rental) entities.get(2);
        ConfirmTask task = new ConfirmTask(rental);
        new Thread(task).start();
        Thread.sleep(2000);
        Assert.assertEquals(((Rental) new RentalLogicImpl().displayById(2).get(2)).getStatus(), "Performed");
    }

}