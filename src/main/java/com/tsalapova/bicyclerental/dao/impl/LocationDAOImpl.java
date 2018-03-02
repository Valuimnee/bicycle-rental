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
    private static final String FIND_BY_ID = "SELECT `location_id`, `name`, `address`, `phone` FROM `location` WHERE `location_id`=?";
    private static final String FIND_ALL = "SELECT `location_id`, `name`, `address`, `phone` FROM `location`";

    @Override
    public Location findById(long locationId) throws DAOException {
        Location location=null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, locationId);
            ResultSet rs = statement.executeQuery();
            List<Location> bicycles = new POJOMapper<Location>().mapPojos(rs, Location.class);
            if (!bicycles.isEmpty()) {
                location = bicycles.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the location", e);
        } finally {
            close(statement, connection);
        }
        return location;
    }

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
            throw new DAOException("Error while finding all locations", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void add(Location location) throws DAOException {

    }

}
