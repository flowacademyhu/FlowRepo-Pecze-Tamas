package com.example.badgesystem.Exception;

public class ValidationErrorUsernameNotUnique extends RuntimeException {
    public ValidationErrorUsernameNotUnique(String username) {
        super("This username " + username + " is already in the database!");
    }
}
