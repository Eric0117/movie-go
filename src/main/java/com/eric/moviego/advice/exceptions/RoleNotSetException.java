package com.eric.moviego.advice.exceptions;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
public class RoleNotSetException extends RuntimeException {
    public RoleNotSetException(String msg, Throwable t) {
        super(msg, t);
    }

    public RoleNotSetException(String msg) {
        super(msg);
    }

    public RoleNotSetException() {
        super();
    }
}