package edu.hw2.task3.exceptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException(Throwable cause) {
        super(cause);
    }

    public ConnectionException() {
    }
}
