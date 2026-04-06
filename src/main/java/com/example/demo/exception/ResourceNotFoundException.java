package com.example.demo.exception;

public class ResourceNotFoundException extends ArithmeticException{
	private String message;

    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
