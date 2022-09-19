package com.eric.moviego.advice.exceptions;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
public class NameDuplicatedException extends RuntimeException {
    public NameDuplicatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public NameDuplicatedException(String msg) {
        super(msg);
    }

    public NameDuplicatedException() {
        super();
    }
}