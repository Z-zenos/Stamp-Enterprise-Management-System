package com.icheck.backend.converter;

import com.icheck.backend.entity.User;
import com.icheck.backend.request.UserRequest;
import com.icheck.backend.response.UserResponse;
import com.icheck.backend.util.ModelMapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public User toEntity(UserRequest userRequest){
        User user = modelMapper.map(userRequest, User.class);
        return user;
    }
    public UserResponse toResponse(User user){
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }
}
