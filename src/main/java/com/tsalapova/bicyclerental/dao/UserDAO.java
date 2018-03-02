package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * The interface of DAO layer that works with User entity
 *
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public interface UserDAO extends GeneralDAO<User> {
    /**
     * Method finds user by his login
     *
     * @param login login of the user
     * @return {@code User} found user or {@code null}
     * @throws DAOException exception thrown in case error occurs
     */
    User findByLogin(String login) throws DAOException;

    /**
     * Method finds all users with specified role (admin or client)
     *
     * @param role role of users to find
     * @return {@code List} of users
     * @throws DAOException exception thrown in case error occurs
     */
    List<User> findByRole(UserRole role) throws DAOException;

    /**
     * Method find id of user by his login
     *
     * @param login login of certain user
     * @return {@code long} id of found user or {@code null}
     * @throws DAOException exception thrown in case error occurs
     */
    long findIdByLogin(String login) throws DAOException;

    /**
     * Method updates login of user by his id
     *
     * @param id    id of certain user
     * @param login new login
     * @throws DAOException exception thrown in case error occurs
     */
    void updateLogin(long id, String login) throws DAOException;

    /**
     * Method sets new password (ans salt) to the specified user
     *
     * @param user changed user
     * @throws DAOException exception thrown in case error occurs
     */
    void updateHashSalt(User user) throws DAOException;

    /**
     * Method deletes user by his id (and also his client info and account for client)
     *
     * @param id id of user to delete
     * @throws DAOException exception thrown in case error occurs
     */
    void deleteById(long id) throws DAOException;
}
