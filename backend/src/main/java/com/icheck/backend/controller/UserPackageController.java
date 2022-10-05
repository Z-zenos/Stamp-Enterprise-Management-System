package com.icheck.backend.controller;

import com.icheck.backend.request.UserPackageRequest;
import com.icheck.backend.service.UserPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPackageController {
    @Autowired
    private UserPackageService service;

    @PostMapping("/user-package")
    public ResponseEntity<Boolean> register(@RequestBody UserPackageRequest userPackageRequest){

    }
}
