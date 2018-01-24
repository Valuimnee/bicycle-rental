package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.User;
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
            //TODO correct minor errors
            List<User> users=new POJOMapper<User>().mapPojos(rs, User.class);
            if(!users.isEmpty()){
                user=users.get(0);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException|SQLException e) {
            throw new DAOException("Error while finding a user.", e);
        } finally {
            close(statement, connection);
        }
        return user;
    }
}
