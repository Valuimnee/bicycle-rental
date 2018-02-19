package com.tsalapova.bicyclerental.validator;

import com.tsalapova.bicyclerental.entity.Account;
import com.tsalapova.bicyclerental.entity.Bicycle;
import com.tsalapova.bicyclerental.entity.Client;
import com.tsalapova.bicyclerental.entity.Location;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class ParameterValidator {
    private final static String PASSWORD_REGEX = "^[^ ]{8,40}$";
    private final static String LOGIN_REGEX = "^[-\\w.]{4,20}$";
    private static final String NAME_REGEX = "^([\\p{L}'][ \\p{L}'-]*\\p{L}|\\p{L}[\\p{L}'-]*)$";
    private static final String PRODUCT_NAME_REGEX = "^([\\p{L}\\d'][ \\p{L}\\d'-.]*[\\p{L}\\d]|[\\p{L}\\d][\\p{L}\\d'-.]*)$";
    private static final String ADDRESS_REGEX = "^([\\p{L}.,-/\\d]+\\s+)*[\\p{L}.,-/\\d]+$";
    private final static String PASSPORT_NUMBER_REGEX = "^(AB|BM|HB|KH|MP|MC|KB|PP)\\d{7}$";
    private final static String EMAIL_REGEX = "^[-+\\w]+(\\.\\w+)*@[\\w-]+(\\.\\w+)*(\\.[a-z]{2,})$";
    private static final String PHONE_REGEX = "^\\d{12}$";

    private boolean validateProductName(String productName){
        return productName!=null&&productName.matches(PRODUCT_NAME_REGEX);
    }

    public boolean validateLogin(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    public boolean validatePassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public boolean validateConfirmPassword(String password, String password2) {
        return password != null && password.equals(password2) && password.matches(PASSWORD_REGEX);
    }

    public boolean validateAddress(String address) {
        return address != null && address.matches(ADDRESS_REGEX);
    }

    public boolean validatePhone(String phone) {
        return phone != null && phone.matches(PHONE_REGEX);
    }

    public boolean validateName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public boolean validatePassportNumber(String passport) {
        return passport != null && passport.matches(PASSPORT_NUMBER_REGEX);
    }

    public boolean validateEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public boolean validateHours(int hours) {
        return hours >= 1 && hours <= 168;
    }

    public boolean validateStartTime(Timestamp timestamp) {
        return timestamp.after(new Timestamp(Calendar.getInstance().getTime().getTime()));
    }

    public boolean validatePricePh(double pricePh){
        return pricePh>=0.01&&pricePh<=100.;
    }

    public boolean validateCurrency(double currency){
        return currency>=0.;
    }

    public boolean validateClientInfo(Client client) {
        return validateName(client.getFirstName()) && (validateName(client.getMiddleName()) ||
                client.getMiddleName().isEmpty()) && validateName(client.getLastname()) &&
                validateAddress(client.getAddress()) && validatePassportNumber(client.getPassportNumber()) &&
                validateEmail(client.getEmail()) && validatePhone(client.getPhone());
    }

    public boolean validateLocation(Location location) {
        return validateName(location.getName()) && validateAddress(location.getAddress()) &&
                validatePhone(location.getPhone());
    }

    public boolean validateBicycle(Bicycle bicycle) {
        return validateProductName(bicycle.getModel())&&validateProductName(bicycle.getBrand())&&
                validatePricePh(bicycle.getPricePh());
    }

    public boolean validateAccount(Account account) {
        return validateCurrency(account.getBalance())&&validateCurrency(account.getCredit());
    }
}
