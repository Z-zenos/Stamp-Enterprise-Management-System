package com.icheck.backend.response;

import com.icheck.backend.exception.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse <T>{
    private int code;
    private String message;
    private T data;
    public BaseResponse(ErrorMessage errorMessage, T data){
        code = errorMessage.getCode();
        message = errorMessage.getMessage();
        this.data = data;
    }
}
