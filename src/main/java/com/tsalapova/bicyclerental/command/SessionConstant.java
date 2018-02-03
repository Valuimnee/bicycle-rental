package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;

import javax.servlet.http.HttpSession;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/1/2018
 */
public class SessionConstant {
    public static final String ID = "id";
    public static final String ROLE = "role";
    public static final String LOGIN = "login";

    void setUserSession(HttpSession session, User user){
        session.setAttribute(SessionConstant.ID, user.getId());
        session.setAttribute(SessionConstant.LOGIN, user.getLogin());

        if(user.getRole().equals(UserRole.ADMIN.getName())) {
            session.setAttribute(SessionConstant.ROLE, SessionConstant.ROLE_NAME.ADMINISTRATOR.name().toLowerCase());
        } else if (user.getRole().equals(UserRole.CLIENT.getName())) {
            session.setAttribute(SessionConstant.ROLE, SessionConstant.ROLE_NAME.USER.name().toLowerCase());
        }
    }

    public enum ROLE_NAME {
        USER, ADMINISTRATOR
    }
}
