package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.RentalDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.mapper.POJOMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public class RentalDAOImpl implements RentalDAO {
    private static final String ADD_RENTAL = "INSERT INTO `rental` (`client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_CLIENT_ID = "SELECT `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `client_id`=?";

    @Override
    public void add(Rental rental) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(ADD_RENTAL);
            statement.setLong(1, rental.getClientId());
            statement.setLong(2, rental.getBicycleId());
            statement.setTimestamp(3, rental.getStartTime());
            statement.setInt(4, rental.getHours());
            statement.setDouble(5, rental.getTotal());
            statement.setString(6, rental.getStatus());
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding rental", e);
        } finally {
            close(statement, connection);
        }
    }

    public List<Rental> findByClientId(long clientId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_CLIENT_ID);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            return new POJOMapper<Rental>().mapPojos(rs, Rental.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rentals by client id", e);
        } finally {
            close(statement, connection);
        }
    }
}
