package com.example.expensetracker.exceptions;

public class BadRequestException extends RuntimeException{
    public static final  long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }
}
