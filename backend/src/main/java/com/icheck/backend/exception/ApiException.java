package com.icheck.backend.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private int code;
    private String message = "";
    private Object data;

    public ApiException(int code) {
        this.code = code;
        this.message = "";
    }

    public ApiException(ErrorMessage exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }

    public ApiException(ErrorMessage exception, Object data) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.data = data;
    }

    public ApiException(ErrorMessage exception, String... data) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.data = data;
    }

    public ApiException(ErrorMessage exception, String errorMsg) {
        super(errorMsg);
        this.code = exception.getCode();
        this.message = errorMsg;
    }

    public ApiException(ErrorMessage exception, String errorMsg, Object data) {
        super(errorMsg);
        this.code = exception.getCode();
        this.message = errorMsg;
        this.data = data;
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ApiException() {
        this.message = "";
    }

    public int getCode() {
        return this.code;
    }
}
