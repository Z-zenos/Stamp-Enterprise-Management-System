package com.icheck.backend.request.user_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    private String name;
    private String phone;
    private String email;
    private String password;
    private String taxCode;
    private String city;
    private String district;
    private String address;

}
