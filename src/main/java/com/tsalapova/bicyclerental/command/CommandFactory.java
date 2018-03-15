package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.exception.CommandException;

/**
 * Factory that creates specific {@code ActionCommand} from it's name.
 *
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public class CommandFactory {
    private static final String PARAMETER_DELIMETER = "-";
    private static final String ENUM_DELIMETER = "_";

    /**
     * Method retrieves an instance of specified {@code ActionCommand} from {@code CommandEnum}
     * for command name.
     *
     * @param command name of the command in lower case with hyphen as delimiter
     * @return {@code ActionCommand} corresponding command
     * @throws CommandException throws in case of error
     */
    public static ActionCommand defineCommand(String command) throws CommandException {
        String commandName = command.replaceAll(PARAMETER_DELIMETER, ENUM_DELIMETER).toUpperCase();
        try {
            return CommandEnum.valueOf(commandName).getCommand();
        } catch (IllegalArgumentException e) {
            throw new CommandException("No command exists for parameter: " + command, e);
        }
    }
}
