package com.erica.project.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String msg)
    {
        super(msg);
    }
}
