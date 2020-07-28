package com.oocl.cultivation.exception;

public class UnrecognizedTicketException extends Exception{
    public UnrecognizedTicketException() {
    }

    public UnrecognizedTicketException(String message) {
        super(message);
    }
}
