package com.icheck.backend.controller;

import com.icheck.backend.DAO.UserDao;
import com.icheck.backend.entity.User;
import com.icheck.backend.request.user_request.AddUserRequest;
import com.icheck.backend.request.user_request.UpdateUserRequest;
import com.icheck.backend.request.user_request.UserRequest;
import com.icheck.backend.response.user_response.*;
import com.icheck.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class UserController {
	// TODO: 
	/*
	 * 1. Lưu password dạng mã hóa sử dụng passwordEncoder. v
	 * 2. Check trùng với những  trường unique.v
	 * 3. Với mỗi API tạo riêng Request, Response.v
	 * 4. tạo 1 class BaseResponse<T> (int code, string message, T data)
	 * 5. Custom bắt tất cả các exception nếu bắn ra thì trả về dạng BaseResponse với code lỗi và message =>>> @RestControllerAdvice
	 */
	
    @Autowired
    private UserService service;
    @Autowired
    private UserDao dao;

    @PostMapping("/user")
    public ResponseEntity<AddUserResponse> add(@RequestBody AddUserRequest request){
        AddUserResponse rsp = service.add(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<DeleteUserResponse> delete(@PathVariable("id") Long id){
        DeleteUserResponse rsp = service.delete(id);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UpdateUserResponse> update(@PathVariable("id") Long id,
                                                     @RequestBody UpdateUserRequest request){
        request.setId(id);
        UpdateUserResponse rsp = service.update(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
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
