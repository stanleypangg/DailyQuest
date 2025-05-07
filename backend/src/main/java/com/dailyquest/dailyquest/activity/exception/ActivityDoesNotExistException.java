package com.dailyquest.dailyquest.activity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ActivityDoesNotExistException extends RuntimeException {

    private final String message;
    public ActivityDoesNotExistException(Long id) {
        super("Activity with id " + id + " does not exist");
        this.message = "Activity with id " + id + " does not exist";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
