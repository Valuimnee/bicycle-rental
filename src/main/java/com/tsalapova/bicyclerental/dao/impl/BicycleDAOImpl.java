package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.BicycleDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.mapper.POJOMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class BicycleDAOImpl implements BicycleDAO {
    private static final String FIND_BY_ID = "SELECT `bicycle_id`, `location_id`, `brand`, `model`, `material`," +
            " `type`, `price_ph` FROM `bicycle` WHERE `bicycle_id`=?";
    private static final String FIND_BY_LOCATION_ID = "SELECT `bicycle_id`, `location_id`, `brand`, `model`, `material`," +
            " `type`, `price_ph` FROM `bicycle` WHERE `location_id`=?";
    private static final String FIND_ALL = "SELECT `bicycle_id`, `location_id`, `brand`, `model`, `material`," +
            " `type`, `price_ph` FROM `bicycle`";
    private static final String FIND_BY_RENTALS_CLIENT_ID = "SELECT `bicycle_id`, `location_id`, `brand`, `model`, `material`," +
            " `type`, `price_ph` FROM `bicycle` WHERE `bicycle_id` IN (SELECT `bicycle_id` FROM `rental` WHERE `client_id`=?)";
    private static final String ADD_BICYCLE = "INSERT INTO `bicycle` (`brand`, `model`, `material`, `type`, `price_ph`)" +
            " VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Bicycle> findByLocation(long locationId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_LOCATION_ID);
            statement.setLong(1, locationId);
            ResultSet rs = statement.executeQuery();
            return new POJOMapper<Bicycle>().mapPojos(rs, Bicycle.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding bicycles by location id", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public List<Bicycle> findAll() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_ALL);
            return new POJOMapper<Bicycle>().mapPojos(rs, Bicycle.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding all bicycles", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public Bicycle findById(long bicycleId) throws DAOException {
        Bicycle bicycle=null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, bicycleId);
            ResultSet rs = statement.executeQuery();
            List<Bicycle> bicycles = new POJOMapper<Bicycle>().mapPojos(rs, Bicycle.class);
            if (!bicycles.isEmpty()) {
                bicycle = bicycles.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the bicycle", e);
        } finally {
            close(statement, connection);
        }
        return bicycle;
    }

    @Override
    public List<Bicycle> findByRentalsClientId(long clientId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_RENTALS_CLIENT_ID);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            return new POJOMapper<Bicycle>().mapPojos(rs, Bicycle.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the bicycle", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void add(Bicycle bicycle) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(ADD_BICYCLE);
            statement.setString(1, bicycle.getBrand());
            statement.setString(2, bicycle.getModel());
            statement.setString(3, bicycle.getMaterial());
            statement.setString(4, bicycle.getType());
            statement.setDouble(5, bicycle.getPricePh());
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding bicycle", e);
        } finally {
            close(statement, connection);
        }
    }
}
