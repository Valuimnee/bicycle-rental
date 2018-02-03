package com.tsalapova.bicyclerental.validator;

import com.tsalapova.bicyclerental.entity.Client;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class ParameterValidator {
    private final static String PASSWORD_REGEX="^[^ ]{8,40}$";
    private final static String LOGIN_REGEX="^[-\\w.]{4,20}$";
    private static final String NAME_REGEX = "^([\\p{L}'][ \\p{L}'-]*\\p{L}|\\p{L}[\\p{L}'-]*)$";
    private static final String ADDRESS_REGEX="^([\\p{L}.,-/\\d]+\\s+)*[\\p{L}.,-/\\d]+$";
    private final static String PASSPORT_NUMBER_REGEX="^(AB|BM|HB|KH|MP|MC|KB|PP)\\d{7}$";
    private final static String EMAIL_REGEX="^[\\w-+]+(\\.\\w+)*@[\\w-]+(\\.\\w+)*(\\.[a-z]{2,})$";
    private static final String PHONE_REGEX = "^\\d{12}$";

    public boolean validatePassword(String password){
        return password!=null&&password.matches(PASSWORD_REGEX);
    }

    public boolean validateConfirmPassword(String password, String password2){
        return password!=null&&password.equals(password2)&&password.matches(PASSWORD_REGEX);
    }

    public boolean validateLogin(String login){
        return login!=null&&login.matches(LOGIN_REGEX);
    }

    public boolean validateClientInfo(Client client){
        boolean isValid=true;
        if(client.getFirstName()==null||!client.getFirstName().matches(NAME_REGEX) ||
                client.getMiddleName()==null||(!client.getMiddleName().matches(NAME_REGEX) && !client.getMiddleName().isEmpty()) ||
                client.getLastname()==null||!client.getLastname().matches(NAME_REGEX)){
            isValid=false;
        }
        if(client.getAddress()==null||(!client.getAddress().matches(ADDRESS_REGEX)&&!client.getAddress().isEmpty())){
            isValid=false;
        }
        if(client.getPassportNumber()==null||!client.getPassportNumber().matches(PASSPORT_NUMBER_REGEX)){
            isValid=false;
        }
        if(client.getEmail()==null||!client.getEmail().matches(EMAIL_REGEX)){
            isValid=false;
        }
        if(client.getPhone()==null||!client.getPhone().matches(PHONE_REGEX)){
            isValid=false;
        }
        return  isValid;
    }
}
