package com.icheck.backend.response.user_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String taxCode;
    private String city;
    private String district;
    private String address;
    private int status;
}
