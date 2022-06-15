package com.example.exceptional_handling.exceptions;

public class EmptyListException extends RuntimeException{

    private String message;

    public EmptyListException(){}

    public EmptyListException(String msg){
        super(msg);
        this.message = msg;
    }
}
