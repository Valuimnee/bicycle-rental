package com.tsalapova.bicyclerental.exception;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public class ConfirmerException extends RuntimeException {
    public ConfirmerException() {
    }

    public ConfirmerException(String message) {
        super(message);
    }

    public ConfirmerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfirmerException(Throwable cause) {
        super(cause);
    }
}
