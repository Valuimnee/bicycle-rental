package com.tsalapova.bicyclerental.dao;

import com.tsalapova.bicyclerental.entity.Rental;
import com.tsalapova.bicyclerental.exception.DAOException;
import javafx.util.Pair;

import java.util.List;

/**
 * The interface of DAO layer that works with Rental entity
 *
 * @author TsalapovaMD
 * @version 1.0, 2/5/2018
 */
public interface RentalDAO extends GeneralDAO<Rental> {
    /**
     * Method finds certain rental by its parameters (such as clientId, bicycleId, start time, etc.)
     *
     * @param rental rental that contains parameters
     * @return {@code Rental} found rental or null
     * @throws DAOException exception thrown in case error occurs
     */
    Rental findByParameters(Rental rental) throws DAOException;

    /**
     * Method finds all rentals of certain client by his id
     *
     * @param clientId id of certain client
     * @return {@code List} of rentals
     * @throws DAOException exception thrown in case error occurs
     */
    List<Rental> findByClientId(long clientId) throws DAOException;

    /**
     * Method finds all rentals of certain client that are in concluded state (not completed)
     *
     * @param clientId id of certain client
     * @return {@code List} of rentals
     * @throws DAOException exception thrown in case error occurs
     */
    List<Rental> findConcludedByClientId(long clientId) throws DAOException;

    /**
     * Method finds all rentals in the concluded state (not completed)
     *
     * @return {@code List} of rentals
     * @throws DAOException exception thrown in case error occurs
     */
    List<Rental> findConcluded() throws DAOException;

    /**
     * Method counts number of rentals for every client by his id and returns them in pairs
     *
     * @return {@code List} of client id and his number of rentals
     * @throws DAOException exception thrown in case error occurs
     */
    List<Pair<Long, Long>> countAllByClientId() throws DAOException;

    /**
     * Method counts number of rental for certain client by his id
     *
     * @param clientId id of certain client
     * @return {@code Long} - number of rentals
     * @throws DAOException exception thrown in case error occurs
     */
    Long countByClientId(long clientId) throws DAOException;

    /**
     * Method sets rental status to Confirmed (completed) by its id
     *
     * @param rentalId id of rental to confirm
     * @throws DAOException exception thrown in case error occurs
     */
    void confirmById(long rentalId) throws DAOException;

    /**
     * Method sets rental status to Canceled by its id
     *
     * @param rentalId id of rental to cancel
     * @throws DAOException exception thrown in case error occurs
     */
    void cancelById(long rentalId) throws DAOException;

    /**
     * Method updates start time and duration of rental
     *
     * @param rental changed rental
     * @throws DAOException exception thrown in case error occurs
     */
    void updateTimeHours(Rental rental) throws DAOException;
}
