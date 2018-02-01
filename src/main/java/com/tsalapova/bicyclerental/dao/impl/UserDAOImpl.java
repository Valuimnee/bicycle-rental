package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.User;
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
 * @version 1.0, 1/3/2018
 */
public class UserDAOImpl implements UserDAO {
    private static final String FIND_BY_LOGIN = "SELECT * FROM `user` WHERE `login`=?";
    private static final String FIND_ID_BY_LOGIN = "SELECT `id` FROM `user` WHERE `login`=?";
    private static final String ADD_USER_CLIENT = "INSERT INTO `user` (`login`, `password`, `salt`, `role`) VALUES (?, ?, ?, 'client')";

    @Override
    public User findByLogin(String login) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_LOGIN);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            List<User> users = new POJOMapper<User>().mapPojos(rs, User.class);
            if (!users.isEmpty()) {
                user = users.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding the user by login.", e);
        } finally {
            close(statement, connection);
        }
        return user;
    }

    @Override
    public long findIdByLogin(String login) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        long id = -1L;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_ID_BY_LOGIN);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while finding user id. "+e.getMessage(), e);
        } finally {
            close(statement, connection);
        }
        return id;
    }

    @Override
    public void addClient(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(ADD_USER_CLIENT);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSalt());
            statement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Error while adding user.", e);
        } finally {
            close(statement, connection);
        }
    }
}
