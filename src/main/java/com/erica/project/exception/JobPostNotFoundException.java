package com.erica.project.exception;

public class JobPostNotFoundException extends RuntimeException {
    public JobPostNotFoundException(String msg) {
        super(msg);
    }
}
