package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.ClientDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Client;
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
 * @version 1.0, 2/1/2018
 */
public class ClientDAOImpl implements ClientDAO {
    private static final String ADD_CLIENT = "INSERT INTO `client` (`client_id`, `first_name`, `middle_name`, `lastname`," +
            " `passport_number`, `address`, `email`, `phone`, `active`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT `client_id`, `first_name`, `middle_name`, `lastname`," +
            " `passport_number`, `address`, `email`, `phone`, `active` FROM `client` WHERE `client_id`=?";


    @Override
    public void add(Client client) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(ADD_CLIENT);
            statement.setLong(1, client.getClientId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getMiddleName());
            statement.setString(4, client.getLastname());
            statement.setString(5, client.getPassportNumber());
            statement.setString(6, client.getAddress());
            statement.setString(7, client.getEmail());
            statement.setString(8, client.getPhone());
            statement.setByte(9, client.getActive());
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding client.", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public Client findById(long clientId) throws DAOException {
        Client client=null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            List<Client> clients = new POJOMapper<Client>().mapPojos(rs, Client.class);
            if (!clients.isEmpty()) {
                client = clients.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the client.", e);
        } finally {
            close(statement, connection);
        }
        return client;
    }
}
