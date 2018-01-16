package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public interface ActionCommand {
    String execute(HttpServletRequest request) throws CommandException;
    //todo
    //Logging
    //PageConstant
    //final
    //parameters in constant
    //close Statement DAO
}
