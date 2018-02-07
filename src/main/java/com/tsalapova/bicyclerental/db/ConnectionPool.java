package com.tsalapova.bicyclerental.db;

import com.tsalapova.bicyclerental.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private final static ReentrantLock instanceLock = new ReentrantLock(true);
    private static ConnectionPool instance;

    private Semaphore semaphore;
    private ArrayDeque<ProxyConnection> available;
    private ArrayDeque<ProxyConnection> taken;
    private final int POOL_SIZE = 20;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instanceLock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            } finally {
                instanceLock.unlock();
            }
        }
        return instance;
    }

    private ConnectionPool() {
        //Protecting from creation of another instance through Reflection API
        if (instance != null) {
            LOGGER.log(Level.FATAL, "Trying to create second instance of singleton class ConnectionPool");
            throw new RuntimeException("Instance of ConnectionPool already exists");
        }

        semaphore=new Semaphore(POOL_SIZE, true);
        available=new ArrayDeque<>(POOL_SIZE);
        taken=new ArrayDeque<>(POOL_SIZE);

        ProxyConnectionFactory factory=ProxyConnectionFactory.getInstance();
        for (int i = 0; i < POOL_SIZE; i++) {
            available.addLast(factory.createProxyConnection());
        }
    }


    //Protecting from creation of another instance through cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (instance != null) {
            throw new CloneNotSupportedException();
        }
        return super.clone();
    }

    public Connection getConnection() throws ConnectionPoolException {
        ProxyConnection connection=null;
        try {
            semaphore.acquire();
            connection=available.removeLast();
            taken.addLast(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error while acquiring connection", e);
        }
        return connection;
    }

    public void returnConnection(ProxyConnection connection) {
        taken.remove(connection);
        available.addLast(connection);
        semaphore.release();
    }

    public void destroyPool() {
        semaphore.acquireUninterruptibly(semaphore.availablePermits());
        try {
            for(ProxyConnection connection: available){
                connection.closeConnection();
            }
            for(ProxyConnection connection: taken){
                connection.closeConnection();
            }
        } catch (SQLException e) {
            //TODO
            LOGGER.log(Level.WARN, "Exception while closing pool connections", e);
        }

        Enumeration<java.sql.Driver> drivers= DriverManager.getDrivers();
        try {
            while(drivers.hasMoreElements()){
                DriverManager.deregisterDriver(drivers.nextElement());
            }
        } catch (SQLException e) {
            //TODO
            LOGGER.log(Level.WARN, "Exception while deregistering database connection drivers", e);
        }

    }

}
