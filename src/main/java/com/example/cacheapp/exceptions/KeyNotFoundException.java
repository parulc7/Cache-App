package com.example.cacheapp.exceptions;

public class KeyNotFoundException extends RuntimeException{
    public KeyNotFoundException(String message){
        super(message);
    }
}
