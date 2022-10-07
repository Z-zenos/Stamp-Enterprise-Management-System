package com.icheck.backend.exception;

import com.icheck.backend.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse<?>> handleConversion(Exception ex) {
        LOGGER.error("ERROR: ", ex);
        BaseResponse response = new BaseResponse();
        response.setMessage(ex.getMessage());
        if (ex instanceof ApiException) {
            ApiException apiException = (ApiException) ex;
            response.setCode(apiException.getCode());
            response.setMessage(apiException.getMessage());
            response.setData(apiException.getData());
        } else {
            response.setCode(500);
            response.setMessage("System Error !");
        }
        return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);
    }
}
