package com.tsalapova.bicyclerental.validator;

import com.tsalapova.bicyclerental.entity.Client;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class ParameterValidator {
    public final static String PASSWORD_REGEX="^[^ ]{8,40}$";
    public final static String LOGIN_REGEX="^[-\\w.]{4,20}$";
    public final static String PASSPORT_NUMBER_REGEX="^[-\\w.]{4,20}$";

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
        if(client.getPassportNumber()==null||!client.getPassportNumber().matches("^(AB|BM|HB|KH|MP|MC|KB|PP)[0-9]{7}$")){
            //request.setAttribute("wrong", "Incorrect passport number! Please, try again.");
            isValid=false;
        }
        return  isValid;
    }
}
