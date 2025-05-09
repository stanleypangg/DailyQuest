package com.dailyquest.dailyquest.habit.exception;


public class HabitDoesNotExistException extends RuntimeException {
    public HabitDoesNotExistException(String message) {
        super(message);
    }
}
