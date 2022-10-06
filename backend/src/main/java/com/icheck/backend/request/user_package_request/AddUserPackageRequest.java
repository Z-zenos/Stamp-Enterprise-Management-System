package com.icheck.backend.request.user_package_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserPackageRequest {
    private Long userId;
    private Long packId;
    private int status;
}
