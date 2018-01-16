package com.tsalapova.bicyclerental.db;

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
            throw new RuntimeException("Instance of ConnectionPool already exists.");
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

    public Connection getConnection() {
        ProxyConnection connection=null;
        try {
            semaphore.acquire();
            connection=available.removeLast();
            taken.addLast(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //TODO
        }
        return connection;
    }

    public void returnConnection(ProxyConnection connection) {
        taken.remove(connection);
        available.addLast(connection);
        semaphore.release();
    }

    public void destroyPool() {
        try {
            semaphore.acquire(semaphore.availablePermits());
        } catch (InterruptedException e) {
            //TODO
        }
        try {
            for(ProxyConnection connection: available){
                connection.closeConnection();
            }
            for(ProxyConnection connection: taken){
                connection.closeConnection();
            }
        } catch (SQLException e) {
            //TODO
        }

        Enumeration<java.sql.Driver> drivers= DriverManager.getDrivers();
        try {

            while(drivers.hasMoreElements()){
                DriverManager.deregisterDriver(drivers.nextElement());
            }
        } catch (SQLException e) {
            //TODO
        }

    }

}
