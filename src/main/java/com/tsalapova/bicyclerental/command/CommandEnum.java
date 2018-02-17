package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.command.bicycleimpl.*;
import com.tsalapova.bicyclerental.command.clientimpl.*;
import com.tsalapova.bicyclerental.command.locationimpl.LocationsCommand;
import com.tsalapova.bicyclerental.command.locationimpl.SelectLocationCommand;
import com.tsalapova.bicyclerental.command.rentalimpl.*;
import com.tsalapova.bicyclerental.command.sessionimpl.LogoutCommand;
import com.tsalapova.bicyclerental.command.userimpl.*;

/**
 * The enum retrieves specified command for the Command factory by name
 *
 * @author TsalapovaMD
 * @version 1.0, 12/28/2017
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand()), LANGUAGE(new LanguageCommand()), REGISTER(new RegisterCommand()),
    ACCOUNT(new AccountCommand()), EDIT_ACCOUNT(new EditAccountCommand()), PROFILE(new ProfileCommand()),
    EDIT_PROFILE(new EditProfileCommand()), DELETE_ACCOUNT(new DeleteAccountCommand()),
    LOCATIONS(new LocationsCommand()), ALL_AVAILABLE_BICYCLES(new AllAvailableBicyclesCommand()),
    ALL_BICYCLES(new AllBicyclesCommand()), BICYCLES_BY_LOCATION(new BicyclesByLocationCommand()),
    SELECT_BICYCLE(new SelectBicycleCommand()), SELECT_DATE(new SelectDateCommand()), RENT(new RentCommand()),
    BACK_TO_DATE(new BackToDateCommand()), CLIENT_RENTALS(new ClientRentalsCommand()),
    CURRENT_CLIENT_RENTALS(new CurrentClientRentalsCommand()), VIEW_RENTAL(new ViewRentalCommand()),
    EDIT_RENTAL(new EditRentalCommand()), CANCEL_RENTAL(new CancelRentalCommand()),
    ADD_BICYCLE_FORM(new AddBicycleFormCommand()), ADD_BICYCLE(new AddBicycleCommand()),
    VIEW_BICYCLE(new ViewBicycleCommand()), EDIT_BICYCLE(new EditBicycleCommand()),
    DELETE_LOCATION(new DeleteLocationCommand()), DELETE_BICYCLE(new DeleteBicycleCommand()),
    SELECT_LOCATION(new SelectLocationCommand()), ASSIGN_LOCATION(new AssignLocationCommand()),
    VIEW_CLIENTS(new ViewClientsCommand()), VIEW_CLIENT(new ViewClientCommand()), CHANGE_STATUS(new ChangeStatusCommand());

    /**
     * Command of the enum object name
     */
    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    /**
     * Getter for enum object&apos;s command
     *
     * @return ActionCommand - corresponding command
     */
    public ActionCommand getCommand() {
        return command;
    }
}
