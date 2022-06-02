package com.acme.dbo.txlog;

import java.io.IOException;

public class SaverDefaultException extends IOException {
    public SaverDefaultException(String message) {
        super(message);
    }

    public SaverDefaultException(String message, Throwable cause) {
        super(message, cause);
    }
}
