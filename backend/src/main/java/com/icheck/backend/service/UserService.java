package com.icheck.backend.service;

import com.icheck.backend.DAO.UserDao;
import com.icheck.backend.converter.BaseConverter;
import com.icheck.backend.entity.User;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.repositority.UserRepo;
import com.icheck.backend.repositority.UserRepoCustom;
import com.icheck.backend.request.user_request.AddUserRequest;
import com.icheck.backend.request.user_request.UpdateUserRequest;
import com.icheck.backend.request.user_request.UserRequest;
import com.icheck.backend.response.pack_response.UpdatePackResponse;
import com.icheck.backend.response.user_response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserService {
    @Autowired
    private BaseConverter converter;
    @Qualifier("userRepoCustom")
    @Autowired
    private  UserRepoCustom repoCustom;
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserDao dao;


    public UserResponse getById(Long id) {
        return converter.toResponse(dao.getById(id), UserResponse.class);

    }

    public DeleteUserResponse delete(Long id) {
        User user = dao.getById(id);
        try{
            repo.delete(user);
        }catch(Exception e){
            if (user == null){
                throw new ApiException();
            }
            e.getStackTrace();
            return null;
        }
        return converter.toResponse(user, DeleteUserResponse.class);
    }

    public UsersResponse search(String name, String email, String phone, String taxCode, String city, String district,String address, int status) {
        return repoCustom.search(name, email, phone, taxCode, city, district,address, status);
    }

    public AddUserResponse add(AddUserRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        request.setPassword(encoder.encode(request.getPassword()));

        User user = converter.toEntity(request, User.class);

        if (repo.findByEmail(user.getEmail()) != null){
            throw new ApiException(ErrorMessage.EMAIL_EXISTED);
        }

        if (repo.findByPhone(user.getPhone()) != null){
            throw new ApiException(ErrorMessage.PHONE_EXISTED);
        }

        if (repo.findByTaxCode(user.getTaxCode()) != null){
            throw new ApiException(ErrorMessage.TAXCODE_EXISTED);
        }

        try{
            repo.save(user);
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
        return converter.toResponse(user, AddUserResponse.class);
    }

    public UpdateUserResponse update(UpdateUserRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        request.setPassword(encoder.encode(request.getPassword()));
        User userUpdated = converter.toEntity(request, User.class);
        User user = dao.getById(request.getId());

        if (repo.findByEmail(userUpdated.getEmail()) != null &&
                (user.getEmail() != userUpdated.getEmail())){

            throw new ApiException(ErrorMessage.EMAIL_EXISTED);
        }
        if (repo.findByTaxCode(userUpdated.getTaxCode()) != null &&
                user.getTaxCode() != userUpdated.getTaxCode()){

            throw new ApiException(ErrorMessage.TAXCODE_EXISTED);
        }
        if (repo.findByPhone(userUpdated.getPhone()) != null &&
                user.getPhone() != userUpdated.getPhone()) {

            throw new ApiException(ErrorMessage.PHONE_EXISTED);
        }
        try{
            repo.save(userUpdated);
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
        return converter.toResponse(user, UpdateUserResponse.class);
    }
}
