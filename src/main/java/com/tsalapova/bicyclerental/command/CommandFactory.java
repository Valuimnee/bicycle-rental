package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public class CommandFactory {
    private static final String PARAMETER_DELIMETER = "-";
    private static final String ENUM_DELIMETER = "_";

    public static ActionCommand defineCommand(String command) throws CommandException {
        String commandName = command.replaceAll(PARAMETER_DELIMETER, ENUM_DELIMETER).toUpperCase();
        try {
            return CommandEnum.valueOf(commandName).getCommand();
        } catch (Exception e) {
            throw new CommandException("No command exists for parameter: "+command, e);
        }
    }
}
