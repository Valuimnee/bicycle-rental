package com.tsalapova.bicyclerental.dao.impl;

import com.tsalapova.bicyclerental.dao.UserDAO;
import com.tsalapova.bicyclerental.db.ConnectionPool;
import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class UserDAOImpl implements UserDAO {
    private static final String[] columns = {"id","login", "password", "salt", "role"};
    private static final String FIND_BY_LOGIN ="SELECT * FROM `user` WHERE `login`=?";

    @Override
    public User findByLogin(String login) {
        User user=null;
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            statement=conn.prepareStatement(FIND_BY_LOGIN);
            statement.setString(1, login);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                //TODO replace with builder classes
                user=defineEntity(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while finding a user.", e);
        } finally {
            //TODO
            close(statement);
            close(conn);
        }
        return user;
    }

    private User defineEntity(ResultSet resultSet) throws SQLException {
        int i=0;
        return new User(resultSet.getLong(columns[i++]), resultSet.getString(columns[i++]), resultSet.getString(columns[i++]),
                resultSet.getString(columns[i++]), resultSet.getString(columns[i]));
    }
}
