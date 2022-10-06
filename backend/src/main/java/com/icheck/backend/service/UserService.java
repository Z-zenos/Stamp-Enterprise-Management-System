package com.icheck.backend.service;

import com.icheck.backend.DAO.UserDao;
import com.icheck.backend.converter.BaseConverter;
import com.icheck.backend.entity.User;
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
import org.springframework.stereotype.Service;

import java.util.List;

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
        return converter.toResponse(repo.findById(id).get(), UserResponse.class);
    }

    public DeleteUserResponse delete(Long id) {
        User user = dao.getById(id);
        try{
            repo.delete(user);
        }catch(Exception e){
            if (user == null){
                System.out.println("Khong tim thay user");
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
        User user = converter.toEntity(request, User.class);
        if (repo.findByEmail(user.getEmail()) != null){
            System.out.println("Email da ton tai");
            return null;
        }
        if (repo.findByPhone(user.getPhone()) != null){
            System.out.println("Phone da ton tai");
            return null;
        }
        if (repo.findByTaxCode(user.getTaxCode()) != null){
            System.out.println("Tax code da ton tai");
            return null;
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
        boolean check = true;
        User userUpdated = converter.toEntity(request, User.class);
        User user = repo.findById(request.getId()).get();

        if (user == null){
            System.out.println("User khong ton tai");
            return null;
        }

        if ((repo.findByEmail(userUpdated.getEmail()).size() > 0) &&
                (user.getEmail() != userUpdated.getEmail())){
            System.out.println("Email da ton tai");
            check = false;
        }
        if (repo.findByTaxCode(userUpdated.getTaxCode()).size() > 0 &&
                user.getTaxCode() != userUpdated.getTaxCode()){
            System.out.println("Tax code da ton tai");
            check = false;
        }
        if (repo.findByPhone(userUpdated.getPhone()).size() > 0 &&
                user.getPhone() != userUpdated.getPhone()){
            System.out.println("Phone da ton tai");
            check = false;
        }
        if (check == false)return null;

        try{
            repo.save(userUpdated);
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
        return converter.toResponse(user, UpdateUserResponse.class);
    }
}
