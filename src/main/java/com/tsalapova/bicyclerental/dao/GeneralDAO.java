package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Entity;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The base interface of DAO layer.
 * All entity-specified interfaces of DAO layer extends this interface.
 * Includes realization of such common methods as closing connection, statement,
 * connection and statement together
 *
 * @param <T> concrete entity for which DAO interface is created
 * @author TsalapovaMD
 * @version 1.0, 12/26/2017
 */
public interface GeneralDAO<T extends Entity> {
    /**
     * Method adds given entity to the concrete entity table
     *
     * @param entity specified concrete entity
     * @throws DAOException is thrown if error occurs while adding entity
     */
    void add(T entity) throws DAOException;

    /**
     * Method finds and retrieves concrete entity by its id
     *
     * @param id id of entity
     * @return concrete entity
     * @throws DAOException is thrown if error occurs while retrieving entity
     */
    T findById(long id) throws DAOException;

    /**
     * Method closes specified statement
     *
     * @param statement {@code Statement} to close
     * @throws DAOException - exception
     */
    default void close(Statement statement) throws DAOException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error while closing statement.", e);
        }
    }

    /**
     * Method closes specified connection
     *
     * @param connection {@code Connection} to close
     * @throws DAOException - exception
     */
    default void close(Connection connection) throws DAOException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error while closing connection.", e);
        }
    }

    /**
     * Method closes the connection and given statement of it
     *
     * @param statement  {@code Statement} to close
     * @param connection {@code Connection} to close
     * @throws DAOException - exception
     */
    default void close(Statement statement, Connection connection) throws DAOException {
        try {
            close(statement);
        } finally {
            close(connection);
        }
    }
}
