package com.example.employee.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundPositionException extends RuntimeException {
    private final String error;

    public EmployeeNotFoundPositionException(String error) {
        this.error = error;
    }

    public EmployeeNotFoundPositionException(String message, String error) {
        super(message);
        this.error = error;
    }

    public EmployeeNotFoundPositionException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

    public EmployeeNotFoundPositionException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public EmployeeNotFoundPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
