package com.icheck.backend.request.user_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String taxCode;
    private String city;
    private String district;
    private String address;
    private int status;
}
