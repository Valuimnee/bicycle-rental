package com.tsalapova.bicyclerental.exception;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class LogicException extends Exception {
    public LogicException() {
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(Throwable cause) {
        super(cause);
    }
}
