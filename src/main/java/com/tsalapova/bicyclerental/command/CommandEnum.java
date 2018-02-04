package com.tsalapova.bicyclerental.command;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand()), LANGUAGE(new LanguageCommand()), REGISTER(new RegisterCommand()),
    ACCOUNT(new AccountCommand()), EDIT_ACCOUNT(new EditAccountCommand()), PROFILE(new ProfileCommand()),
    EDIT_PROFILE(new EditProfileCommand()), DELETE_ACCOUNT(new DeleteAccountCommand()),
    LOCATIONS(new LocationsCommand()), ALL_BICYCLES(new AllBicyclesCommand()), BICYCLES_BY_LOCATION(new BicyclesByLocationCommand());

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
