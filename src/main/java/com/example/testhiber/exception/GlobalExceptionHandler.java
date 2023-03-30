package com.example.testhiber.exception;

import com.example.testhiber.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleUserNotFound(UserNotFoundException userNotFoundException)
    {
        return new Response(404, userNotFoundException.getMessage());
    }
}
