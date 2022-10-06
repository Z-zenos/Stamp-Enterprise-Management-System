package com.icheck.backend.response.user_response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Data
public class UsersResponse {
    List<UserResponse> userResponseList;
    public UsersResponse(){
        userResponseList = new ArrayList<>();
    }
}
