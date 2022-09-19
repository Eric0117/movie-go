package com.eric.moviego.advice.exceptions;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
public class EmailDuplicatedException extends RuntimeException {
    public EmailDuplicatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public EmailDuplicatedException(String msg) {
        super(msg);
    }

    public EmailDuplicatedException() {
        super();
    }
}
