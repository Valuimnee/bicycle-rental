package com.tsalapova.bicyclerental.exception;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class CommandException extends Exception {
    public CommandException() {
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }
}
