package com.icheck.backend.service;

import com.icheck.backend.converter.UserConverter;
import com.icheck.backend.entity.User;
import com.icheck.backend.repositority.UserRepo;
import com.icheck.backend.repositority.UserRepoCustom;
import com.icheck.backend.request.UserRequest;
import com.icheck.backend.response.UserResponse;
import com.icheck.backend.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private UserConverter converter;
    @Qualifier("userRepoCustom")
    @Autowired
    private  UserRepoCustom repoCustom;
    @Autowired
    private UserRepo repo;

    public UserResponse save(UserRequest userRequest) {
        User user = converter.toEntity(userRequest);
        try {
            repo.save(user);
            UserResponse userResponse = converter.toResponse(user);
            return userResponse;
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public UserResponse getById(Long id) {
        return converter.toResponse(repo.findById(id).get());
    }

    public UserResponse delete(User user) {
        try{
            repo.delete(user);
            return converter.toResponse(user);
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public UsersResponse search(String name, String email, String phone, String taxCode, String city, String district,String address, int status) {
        return repoCustom.search(name, email, phone, taxCode, city, district,address, status);
    }
}
