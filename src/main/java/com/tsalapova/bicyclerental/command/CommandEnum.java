package com.tsalapova.bicyclerental.command;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand()), LANGUAGE(new LanguageCommand()), REGISTER(new RegisterCommand()),
    ACCOUNT(new AccountCommand()), EDIT_ACCOUNT(new EditAccountCommand()), PROFILE(new ProfileCommand()), EDIT_PROFILE(new EditProfileCommand()),
    DELETE_ACCOUNT(new DeleteAccountCommand())/*,
    DELETE_CLIENT(new DeleteClientCommand()),
    VIEW_PROFILE(new ViewProfileCommand()), VIEW_LOGIN(new ViewClientAccountCommand()),
    EDIT_CLIENT(new EditClientCommand()), EDIT_CLIENT_ACCOUNT(new EditClientAccountCommand())*/;

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
