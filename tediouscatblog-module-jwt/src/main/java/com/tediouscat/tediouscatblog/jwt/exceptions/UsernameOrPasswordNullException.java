package com.tediouscat.tediouscatblog.jwt.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}
