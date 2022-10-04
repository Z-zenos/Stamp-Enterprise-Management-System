package com.icheck.backend.controller;

import com.icheck.backend.DAO.UserDao;
import com.icheck.backend.entity.User;
import com.icheck.backend.request.UserRequest;
import com.icheck.backend.response.UserResponse;
import com.icheck.backend.response.UsersResponse;
import com.icheck.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserDao dao;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> add(@RequestBody  UserRequest userRequest){
        userRequest.setStatus(1);
        UserResponse userResponse = service.save(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable("id") Long id){
        User user = dao.getById(id);
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
    @GetMapping("/users")
    public ResponseEntity<UsersResponse> search(@RequestParam(name = "name", defaultValue = "", required = false) String name,
                                                @RequestParam(name = "email", required = false, defaultValue = "") String email,
                                                @RequestParam(name = "phone", required = false, defaultValue = "") String phone,
                                                @RequestParam(name = "taxCode", required = false, defaultValue = "") String taxCode,
                                                @RequestParam(name = "city", required = false, defaultValue = "") String city,
                                                @RequestParam(name = "district", required = false, defaultValue = "") String district,
                                                @RequestParam(name = "address", required = false, defaultValue = "") String address,
                                                @RequestParam(name = "status", required = false, defaultValue = "-1") String status
                                                ){
        UsersResponse rsp = service.search(name, email, phone, taxCode, city, district,address, Integer.valueOf(status));
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable(name = "id") Long id){
        UserResponse rsp = service.getById(id);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
}
