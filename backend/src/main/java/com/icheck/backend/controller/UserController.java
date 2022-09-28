package com.icheck.backend.controller;

import com.icheck.backend.entity.User;
import com.icheck.backend.request.UserRequest;
import com.icheck.backend.response.UserResponse;
import com.icheck.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> add(@RequestBody  UserRequest userRequest){
        UserResponse userResponse = service.save(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable("id") Long id){
        User user = service.getById(id);
        UserResponse userResponse = service.delete(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long id,
                                               @RequestBody UserRequest request){
        request.setId(id);
        UserResponse rsp = service.save(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
}
