package com.dailyquest.dailyquest.habit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HabitDoesNotExistException extends RuntimeException {

    private final String message;
    public HabitDoesNotExistException(Long id) {
      super("Habit with id " + id + " does not exist");
      this.message = "Activity with id" + id + " does not exist";
    }

    @Override
    public String getMessage() { return this.message; }
}
