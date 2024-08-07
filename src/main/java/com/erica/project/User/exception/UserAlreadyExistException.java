package com.erica.project.User.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String msg)
    {
        super(msg);
    }
}
