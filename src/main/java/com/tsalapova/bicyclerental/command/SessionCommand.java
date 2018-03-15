package com.tsalapova.bicyclerental.command;

import com.tsalapova.bicyclerental.entity.User;
import com.tsalapova.bicyclerental.entity.UserRole;
import com.tsalapova.bicyclerental.util.DocumentConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * The interface includes common methods for commands, tha works with user session and role
 * such as set user session
 *
 * @author TsalapovaMD
 * @version 1.0, 2/11/2018
 */
public interface SessionCommand extends ActionCommand {
    /**
     * Method sets user id, login and role to session
     *
     * @param session {@code HttpSession} - current session
     * @param user    current user
     */
    default void setUserSession(HttpSession session, User user) {
        session.setAttribute(SessionConstant.ID, user.getId());
        session.setAttribute(SessionConstant.LOGIN, user.getLogin());
        String roleName = null;
        if (user.getRole().equals(UserRole.ADMIN.getName())) {
            roleName = SessionConstant.ROLE_NAME.ADMINISTRATOR.name().toLowerCase();
        } else if (user.getRole().equals(UserRole.CLIENT.getName())) {
            roleName = SessionConstant.ROLE_NAME.USER.name().toLowerCase();
        }
        session.setAttribute(SessionConstant.ROLE, roleName);
    }

    /**
     * Method removes all attributes from the current session
     * except &Prime;lang&Prime; attribute
     *
     * @param session current session
     */
    default void clearUserSession(HttpSession session) {
        Enumeration<String> attributes = session.getAttributeNames();
        String attribute;
        while (attributes.hasMoreElements()) {
            attribute = attributes.nextElement();
            if (!attribute.equals(DocumentConstant.LANG)) {
                session.removeAttribute(attribute);
            }
        }
    }
}
