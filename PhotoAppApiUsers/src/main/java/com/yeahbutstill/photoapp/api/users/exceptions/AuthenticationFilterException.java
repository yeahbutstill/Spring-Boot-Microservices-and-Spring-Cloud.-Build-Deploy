package com.yeahbutstill.photoapp.api.users.exceptions;

import java.io.Serial;

public class AuthenticationFilterException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8608074283933717024L;

    public AuthenticationFilterException(String message) {
        super(message);
    }

}
