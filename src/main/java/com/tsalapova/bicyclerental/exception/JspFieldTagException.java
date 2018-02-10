package com.tsalapova.bicyclerental.exception;

import javax.servlet.jsp.JspTagException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/10/2018
 */
public class JspFieldTagException extends JspTagException {
    public JspFieldTagException() {
    }

    public JspFieldTagException(String msg) {
        super(msg);
    }

    public JspFieldTagException(String message, Throwable cause) {
        super(message, cause);
    }

    public JspFieldTagException(Throwable cause) {
        super(cause);
    }
}
