package com.acme.dbo.txlog;

public class LogException extends RuntimeException {
    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }
}
