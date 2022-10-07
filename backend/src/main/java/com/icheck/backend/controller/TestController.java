package com.icheck.backend.controller;

import com.icheck.backend.response.user_response.UsersResponse;
import com.icheck.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService service;
    @CrossOrigin(origins = "*")
    @GetMapping("/public/test")
    public ResponseEntity<UsersResponse> hello(){
        UsersResponse rsp = service.search("", "", "", "", "", "","", -1);
        return new ResponseEntity<>(rsp, HttpStatus.OK);

    }
}
