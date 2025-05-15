package com.dailyquest.dailyquest.activity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HabitNotFoundException extends RuntimeException {

    private final String message;
    public HabitNotFoundException(Long id) {

        super("Habit with id " + id + " does not exist");
        this.message = "Habit with id " + id + " does not exist";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
