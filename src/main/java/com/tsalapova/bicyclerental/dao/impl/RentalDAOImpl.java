package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.RentalDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import com.tsalapova.bicyclerental.exception.DAOException;
import com.tsalapova.bicyclerental.mapper.POJOMapper;
import javafx.util.Pair;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public class RentalDAOImpl implements RentalDAO {
    private static final String ADD_RENTAL = "INSERT INTO `rental` (`rental_id`, `client_id`, `bicycle_id`, `start_time`," +
            " `hours`, `total`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_NEXT_ID = "SELECT MAX(`rental_id`)+1 AS 'next_id' FROM `rental`";
    private static final String FIND_BY_ID = "SELECT `rental_id`, `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `rental_id`=?";
    private static final String FIND_BY_PARAMETERS = "SELECT `rental_id`, `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `client_id`=? AND `bicycle_id`=? AND `start_time`=? AND `hours`=?";
    private static final String FIND_BY_CLIENT_ID = "SELECT `rental_id`, `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `client_id`=?";
    private static final String FIND_CONCLUDED_BY_CLIENT_ID = "SELECT `rental_id`, `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `client_id`=? AND `status`='Concluded'";
    private static final String FIND_CONCLUDED = "SELECT `rental_id`, `client_id`, `bicycle_id`, `start_time`, `hours`," +
            " `total`, `status` FROM `rental` WHERE `status`='Concluded'";
    private static final String CANCEL_BY_ID = "UPDATE `rental` SET `status`='Canceled' WHERE `rental_id`=?";
    private static final String CONFIRM_BY_ID = "UPDATE `rental` SET `status`='Performed' WHERE `rental_id`=?";
    private static final String UPDATE_TIME_HOURS_BY_ID = "UPDATE `rental` SET `start_time`=?, `hours`=?, `total`=? WHERE `rental_id`=?";
    private static final String COUNT_ALL_BY_CLIENT_ID = "SELECT `client_id`, COUNT(*) AS 'count' FROM `rental` GROUP BY `client_id`";
    private static final String COUNT_BY_CLIENT_ID = "SELECT COUNT(*) AS 'count' FROM `rental` WHERE `client_id`=?";

    @Override
    public void add(Rental rental) throws DAOException {
        Connection connection = null;
        Statement idStatement = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            idStatement = connection.createStatement();
            statement = connection.prepareStatement(ADD_RENTAL);
            ResultSet idRs = idStatement.executeQuery(FIND_NEXT_ID);
            if (idRs.next()) {
                rental.setRentalId(idRs.getLong(1));
            } else {
                throw new DAOException("Error while adding rental");
            }
            statement.setLong(1, rental.getRentalId());
            statement.setLong(2, rental.getClientId());
            statement.setLong(3, rental.getBicycleId());
            statement.setTimestamp(4, rental.getStartTime());
            statement.setInt(5, rental.getHours());
            statement.setDouble(6, rental.getTotal());
            statement.setString(7, rental.getStatus());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding rental", e);
        } finally {
            close(idStatement);
            close(statement, connection);
        }
    }

    @Override
    public Rental findById(long rentalId) throws DAOException {
        Rental rental = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, rentalId);
            ResultSet rs = statement.executeQuery();
            List<Rental> rentals = new POJOMapper<Rental>().mapPojos(rs, Rental.class);
            if (!rentals.isEmpty()) {
                rental = rentals.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rental by id", e);
        } finally {
            close(statement, connection);
        }
        return rental;
    }

    @Override
    public Rental findByParameters(Rental rental) throws DAOException {
        Rental foundRental = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_PARAMETERS);
            statement.setLong(1, rental.getClientId());
            statement.setLong(2, rental.getBicycleId());
            statement.setTimestamp(3, rental.getStartTime());
            statement.setInt(4, rental.getHours());
            ResultSet rs = statement.executeQuery();
            List<Rental> rentals = new POJOMapper<Rental>().mapPojos(rs, Rental.class);
            if (!rentals.isEmpty()) {
                foundRental = rentals.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rental by id", e);
        } finally {
            close(statement, connection);
        }
        return foundRental;
    }

    private List<Rental> findRentalsByClientId(long clientId, String query) throws DAOException, ConnectionPoolException,
            SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(query);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            return new POJOMapper<Rental>().mapPojos(rs, Rental.class);
        } finally {
            close(statement, connection);
        }
    }

    public List<Rental> findByClientId(long clientId) throws DAOException {
        try {
            return findRentalsByClientId(clientId, FIND_BY_CLIENT_ID);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rentals by client id", e);
        }
    }

    public List<Rental> findConcludedByClientId(long clientId) throws DAOException {
        try {
            return findRentalsByClientId(clientId, FIND_CONCLUDED_BY_CLIENT_ID);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding concluded rentals by client id", e);
        }
    }

    @Override
    public List<Rental> findConcluded() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_CONCLUDED);
            return new POJOMapper<Rental>().mapPojos(rs, Rental.class);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding concluded rentals", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void cancelById(long rentalId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(CANCEL_BY_ID);
            statement.setLong(1, rentalId);
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while canceling the rental", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void confirmById(long rentalId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(CONFIRM_BY_ID);
            statement.setLong(1, rentalId);
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while confirming the rental", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public void updateTimeHours(Rental rental) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_TIME_HOURS_BY_ID);
            statement.setTimestamp(1, rental.getStartTime());
            statement.setInt(2, rental.getHours());
            statement.setDouble(3, rental.getTotal());
            statement.setLong(4, rental.getRentalId());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while updating the rental", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public List<Pair<Long, Long>> countAllByClientId() throws DAOException {
        final String clientIdColumn = "client_id";
        final String countColumn = "count";
        Connection connection = null;
        Statement statement = null;
        List<Pair<Long, Long>> rentals = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(COUNT_ALL_BY_CLIENT_ID);
            while (rs.next()) {
                rentals.add(new Pair<Long, Long>(rs.getLong(clientIdColumn), rs.getLong(countColumn)));
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rental counts by client", e);
        } finally {
            close(statement, connection);
        }
        return rentals;
    }

    @Override
    public Long countByClientId(long clientId) throws DAOException {
        final String countColumn = "count";
        Connection connection = null;
        PreparedStatement statement = null;
        Long count = -1L;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(COUNT_BY_CLIENT_ID);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                count = rs.getLong(countColumn);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding rental count by client id", e);
        } finally {
            close(statement, connection);
        }
        return count;
    }
}
