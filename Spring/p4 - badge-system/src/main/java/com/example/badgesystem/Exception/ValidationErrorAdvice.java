package com.example.badgesystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidationErrorAdvice {

    @ResponseBody
    @ExceptionHandler(ValidationErrorUsernameNotUnique.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String UsernameNotUnique(ValidationErrorUsernameNotUnique e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ValidationErrorUsernameEmpty.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String UsernameEmpty(ValidationErrorUsernameEmpty e) {
        return e.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(ValidationErrorBadgeNameNotUnique.class)
    @ResponseStatus(HttpStatus.LOCKED)
    public String BadgeNameNotUnique(ValidationErrorBadgeNameNotUnique e) {
        return e.getMessage();
    }
}
