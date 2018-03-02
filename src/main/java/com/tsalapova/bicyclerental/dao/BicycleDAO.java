package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.exception.DAOException;

import java.util.List;

/**
 * The interface of DAO layer that works with Bicycle entity
 *
 * @author TsalapovaMD
 * @version 1.0, 2/4/2018
 */
public interface BicycleDAO extends GeneralDAO<Bicycle> {
    /**
     * Method finds all bicycles that belongs to location specified by id
     *
     * @param locationId id of location
     * @return {@code List} of bicycles
     * @throws DAOException exception thrown in case error occurs
     */
    List<Bicycle> findByLocation(long locationId) throws DAOException;

    /**
     * Method finds all bicycles available for rent
     *
     * @return {@code List} of bicycles
     * @throws DAOException exception thrown in case error occurs
     */
    List<Bicycle> findAllAvailable() throws DAOException;

    /**
     * Method finds all bicycles belonging to rental
     *
     * @return {@code List} of bicycles
     * @throws DAOException exception thrown in case error occurs
     */
    List<Bicycle> findAll() throws DAOException;

    /**
     * Method finds all bicycles that was rented by certain client
     *
     * @param clientId id of client
     * @return {@code List} of bicycles
     * @throws DAOException exception thrown in case error occurs
     */
    List<Bicycle> findByRentalsClientId(long clientId) throws DAOException;

    /**
     * Method updates bicycle parameters
     *
     * @param bicycle changed bicycle
     * @throws DAOException exception thrown in case error occurs
     */
    void update(Bicycle bicycle) throws DAOException;

    /**
     * Method sets id of location to which bicycle belong
     *
     * @param bicycleId  id of bicycle
     * @param locationId id of location to set
     * @throws DAOException exception thrown in case error occurs
     */
    void assignLocationById(long bicycleId, long locationId) throws DAOException;

    /**
     * Method deletes any information about location from bicycle
     *
     * @param bicycleId id of certain bicycle
     * @throws DAOException exception thrown in case error occurs
     */
    void deleteLocationById(long bicycleId) throws DAOException;

    /**
     * Method deletes bicycle by its id
     *
     * @param bicycleId id of bicycle to be deleted
     * @throws DAOException exception thrown in case error occurs
     */
    void deleteById(long bicycleId) throws DAOException;
}
