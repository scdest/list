package com.simple.list.exceptions;

public class AccessForbiddenException extends RuntimeException {
    public AccessForbiddenException(String message) {
        super(message);
    }
}
