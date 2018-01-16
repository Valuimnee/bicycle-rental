package com.tsalapova.bicyclerental.exception;


/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
