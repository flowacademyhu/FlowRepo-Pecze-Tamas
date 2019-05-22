package com.example.badgesystem.Exception;

public class ValidationErrorBadgeNameNotUnique extends RuntimeException {
    public ValidationErrorBadgeNameNotUnique(String badgename) {
        super("This badge name is already in the database: " + badgename);
    }
}
