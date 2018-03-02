package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.AccountDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.Account;
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
 * @version 1.0, 2/11/2018
 */
public class AccountDAOImpl implements AccountDAO {
    private static final String ADD_ACCOUNT = "INSERT INTO `account` (`client_id`, `balance`, `credit`) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT `client_id`, `balance`, `credit` FROM `account` WHERE `client_id`=?";
    private static final String UPDATE_BY_ID = "UPDATE `account` SET `credit`=`credit`+GREATEST(?-`balance`, 0)," +
            " `balance`=GREATEST(`balance`-?, 0) WHERE `client_id`=?";

    @Override
    public void add(Account account) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(ADD_ACCOUNT);
            statement.setLong(1, account.getClientId());
            statement.setDouble(2, account.getBalance());
            statement.setDouble(3, account.getCredit());
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding client account", e);
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public Account findById(long clientId) throws DAOException {
        Account account = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, clientId);
            ResultSet rs = statement.executeQuery();
            List<Account> accounts = new POJOMapper<Account>().mapPojos(rs, Account.class);
            if (!accounts.isEmpty()) {
                account = accounts.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the account of the client", e);
        } finally {
            close(statement, connection);
        }
        return account;
    }

    @Override
    public void update(long clientId, double total) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setDouble(1, total);
            statement.setDouble(2, total);
            statement.setLong(3, clientId);
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while updating balance and credit of the client", e);
        } finally {
            close(statement, connection);
        }
    }
}
