package com.example.badgesystem.Exception;

public class ValidationErrorUsernameEmpty extends RuntimeException {
    public ValidationErrorUsernameEmpty() {
        super("You must add a username!");
    }
}
