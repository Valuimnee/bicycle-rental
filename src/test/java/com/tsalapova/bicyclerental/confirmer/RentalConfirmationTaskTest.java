package com.tsalapova.bicyclerental.confirmer;

import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.logic.LogicInjector;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class RentalConfirmationTaskTest {
    @Test
    public void testRun() throws Exception {
        List<Entity> entities = new LogicInjector().getRentalLogic().displayById(2);
        Rental rental = (Rental) entities.get(2);
        RentalConfirmationTask task = new RentalConfirmationTask(rental);
        new Thread(task).start();
        Thread.sleep(2000);
        Assert.assertEquals(((Rental) new LogicInjector().getRentalLogic().displayById(2).get(2)).getStatus(), "Performed");
    }

}