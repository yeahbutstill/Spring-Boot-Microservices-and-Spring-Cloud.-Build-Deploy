package com.yeahbutstill.app.ws.exceptions;

import java.io.Serial;

public class UserServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8608074283933717024L;

    public UserServiceException(String message) {
        super(message);
    }

}
