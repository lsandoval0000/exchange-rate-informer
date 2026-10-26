package org.abc.exception;

public class InvalidDniException extends RuntimeException {
    public InvalidDniException(String message) {
        super(message);
    }
}
