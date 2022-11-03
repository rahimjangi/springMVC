package com.raiseup.springMVC.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
