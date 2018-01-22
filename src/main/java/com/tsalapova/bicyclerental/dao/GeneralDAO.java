package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.exception.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/26/2017
 */
public interface GeneralDAO<T> {

    default void close(Statement statement) throws DAOException {
        try {
            if (statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error while closing statement.", e);
        }
    }

    default void close(Connection connection) throws DAOException {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error while closing connection.", e);
        }
    }

    default void close(Statement statement, Connection connection) throws DAOException {
        try {
            close(statement);
        } finally {
            close(connection);
        }
    }
}
