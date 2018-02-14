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
    private static final String ADD_BICYCLE = "INSERT INTO `bicycle` (`brand`, `model`, `material`, `type`," +
            " `price_ph`) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM `bicycle` WHERE `bicycle_id`=?";
    private static final String UPDATE = "UPDATE `bicycle` SET `brand`=?, `model`=?, `material`=?," +
            " `type`=?, `price_ph`=? WHERE `bicycle_id`=?";
    private static final String DELETE_LOCATION_BY_ID = "UPDATE `bicycle` SET `location_id`=NULL WHERE `bicycle_id`=?";
    private static final String UPDATE_LOCATION_BY_ID = "UPDATE `bicycle` SET `location_id`=? WHERE `bicycle_id`=?";

    private List<Bicycle> findBicycles(long idParameter, String query, String exceptionMessage) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(query);
            statement.setLong(1, idParameter);
            ResultSet rs = statement.executeQuery();
            return new POJOMapper<Bicycle>().mapPojos(rs, Bicycle.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException(exceptionMessage, e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public List<Bicycle> findByLocation(long locationId) throws DAOException {
        return findBicycles(locationId, FIND_BY_LOCATION_ID,
                "Error while finding bicycles by location id");
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
        List<Bicycle> bicycles = findBicycles(bicycleId, FIND_BY_ID,
                "Error while finding the bicycle");
        return !bicycles.isEmpty() ? bicycles.get(0) : null;
    }

    @Override
    public List<Bicycle> findByRentalsClientId(long clientId) throws DAOException {
        return findBicycles(clientId, FIND_BY_RENTALS_CLIENT_ID,
                "Error while finding bicycles for client rentals");
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
            throw new DAOException("Error while adding a bicycle", e);
        } finally {
            close(statement, connection);
        }
    }

    private void deleteByIdParameter(long idParameter, String query, String exceptionMessage) throws DAOException{
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(query);
            statement.setLong(1, idParameter);
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(exceptionMessage, e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void deleteById(long bicycleId) throws DAOException {
        deleteByIdParameter(bicycleId, DELETE_BY_ID, "Error occurred while deleting the bicycle");
    }

    @Override
    public void edit(Bicycle bicycle) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, bicycle.getBrand());
            statement.setString(2, bicycle.getModel());
            statement.setString(3, bicycle.getMaterial());
            statement.setString(4, bicycle.getType());
            statement.setDouble(5, bicycle.getPricePh());
            statement.setLong(6, bicycle.getBicycleId());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while updating the bicycle", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void deleteLocationById(long bicycleId) throws DAOException {
        deleteByIdParameter(bicycleId, DELETE_LOCATION_BY_ID,
                "Error occurred while deleting bicycle location");
    }

    @Override
    public void assignLocationById(long bicycleId, long locationId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_LOCATION_BY_ID);
            statement.setLong(1, locationId);
            statement.setLong(2, bicycleId);
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while updating the location of the bicycle", e);
        } finally {
            close(statement, connection);
        }
    }
}
