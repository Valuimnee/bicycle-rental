package com.tsalapova.bicyclerental.db;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
class ProxyConnectionFactory {
    private static final Logger LOGGER = LogManager.getLogger(ProxyConnectionFactory.class);

    private static ProxyConnectionFactory instance;

    private final String URL;
    private Properties properties;

    static ProxyConnectionFactory getInstance() {
        if (instance == null)
            instance = new ProxyConnectionFactory();
        return instance;
    }

    private ProxyConnectionFactory() {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        String driver = "com.mysql.cj.jdbc.Driver";
        if (rb == null) {
            throw new RuntimeException("Database properties file not found");
        }
        URL = rb.getString("url");
        driver = rb.getString("driver");
        properties = new Properties();
        properties.setProperty("user", rb.getString("user"));
        properties.setProperty("password", rb.getString("password"));
        properties.setProperty("useSSL", "true");
        try {
            DriverManager.registerDriver((java.sql.Driver) Class.forName(driver).newInstance());
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, "ProxyConnectionFactory failed to register database driver: " + driver, e);
            throw new RuntimeException("Can not register database driver: " + driver + ".", e);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException exc) {
            LOGGER.log(Level.FATAL, "Database driver " + driver +" in database properties file is invalid", exc);
            throw new RuntimeException("Database driver in database properties file is invalid", exc);
        }
    }

    ProxyConnection createProxyConnection() {
        try {
            return new ProxyConnection(DriverManager.getConnection(URL, properties));
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, "Connection to database: " + URL + " was not established", e);
            throw new RuntimeException("Connection to database: " + URL + " was not established", e);
        }
    }
}
