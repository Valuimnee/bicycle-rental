package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.LocationDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Location;
import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.mapper.POJOMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/3/2018
 */
public class LocationDAOImpl implements LocationDAO {
    private static final String FIND_ALL = "SELECT * FROM `location`";

    @Override
    public List<Location> findAll() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_ALL);
            return new POJOMapper<Location>().mapPojos(rs, Location.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while displaying all locations.", e);
        } finally {
            close(statement, connection);
        }
    }
}
