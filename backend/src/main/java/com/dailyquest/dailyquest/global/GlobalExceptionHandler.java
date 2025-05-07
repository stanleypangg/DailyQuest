package com.dailyquest.dailyquest.global;

import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ActivityDoesNotExistException.class)
//    public ResponseEntity<ErrorResponse> handleActivityDoesNotExistException(
//            ActivityDoesNotExistException e, HttpServletRequest request) {
//        ErrorResponse error = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                e.getMessage(),
//                request.getRequestURI(),
//                e.getClass().getName()
//        );
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
}
