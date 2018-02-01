package com.tsalapova.bicyclerental.mapper;

import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/24/2018
 */
public class POJOMapperTest {
    @Test
    public void mapPojosTest(){
        try {
            Statement st=ConnectionPool.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `user` WHERE `login`='hochwitt'");
            User user = new POJOMapper<User>().mapPojos(rs, User.class).get(0);
            System.out.println(user);
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException |ConnectionPoolException  e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }
}
