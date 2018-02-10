package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.exception.DAOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public interface UserDAO extends GeneralDAO<User> {
    /**
     *
     * @param login
     * @return
     * @throws DAOException
     */
    User findByLogin(String login) throws DAOException;

    /**
     *
     * @param login
     * @return
     * @throws DAOException
     */
    long findIdByLogin(String login) throws DAOException;

    /**
     *
     * @param user
     * @throws DAOException
     */
    void addClient(User user) throws DAOException;

    /**
     *
     * @param id
     * @param login
     * @throws DAOException
     */
    void updateLogin(long id, String login) throws DAOException;
    void updateHashSalt(User user) throws DAOException;
    void deleteById(long id) throws DAOException;
}
