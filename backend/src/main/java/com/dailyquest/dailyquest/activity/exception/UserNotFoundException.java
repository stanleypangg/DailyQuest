package com.dailyquest.dailyquest.activity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private final String message;
    public UserNotFoundException(String user) {

        super("Username " + user + " does not exist");
        this.message = "Username " + user + " does not exist";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
