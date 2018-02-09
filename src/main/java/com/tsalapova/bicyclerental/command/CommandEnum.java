package com.tsalapova.bicyclerental.command;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand()), LANGUAGE(new LanguageCommand()), REGISTER(new RegisterCommand()),
    ACCOUNT(new AccountCommand()), EDIT_ACCOUNT(new EditAccountCommand()), PROFILE(new ProfileCommand()),
    EDIT_PROFILE(new EditProfileCommand()), DELETE_ACCOUNT(new DeleteAccountCommand()),
    LOCATIONS(new LocationsCommand()), ALL_BICYCLES(new AllBicyclesCommand()), BICYCLES_BY_LOCATION(new BicyclesByLocationCommand()),
    SELECT_BICYCLE(new SelectBicycleCommand()), SELECT_DATE(new SelectDateCommand()), RENT(new RentCommand()),
    BACK_TO_DATE(new BackToDateCommand()), CLIENT_RENTALS(new ClientRentalsCommand()), CURRENT_CLIENT_RENTALS(new CurrentClientRentalsCommand()),
    RENTAL(new RentalCommand()), EDIT_RENTAL(new EditRentalCommand()), CANCEL_RENTAL(new CancelRentalCommand()),
    ADD_BICYCLE_FORM(new AddBicycleFormCommand()), ADD_BICYCLE(new AddBicycleCommand());

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
