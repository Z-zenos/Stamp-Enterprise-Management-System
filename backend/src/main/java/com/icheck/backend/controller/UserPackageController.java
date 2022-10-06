package com.icheck.backend.controller;

import com.icheck.backend.request.user_package_request.AddUserPackageRequest;
import com.icheck.backend.response.user_packge_response.AddUserPackageResponse;
import com.icheck.backend.service.UserPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPackageController {
    @Autowired
    private UserPackageService service;

    @PostMapping("/user-package")
    public ResponseEntity<AddUserPackageResponse> register(@RequestBody AddUserPackageRequest request){
        AddUserPackageResponse rsp = service.add(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
}
