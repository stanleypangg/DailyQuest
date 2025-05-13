package com.dailyquest.dailyquest.habit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class HabitAccessDeniedException extends RuntimeException {
    public HabitAccessDeniedException(Long id) {
        super("You do not own habit #" + id);
    }
}
