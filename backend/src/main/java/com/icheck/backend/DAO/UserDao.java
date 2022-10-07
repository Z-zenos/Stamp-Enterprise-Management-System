package com.icheck.backend.DAO;

import com.icheck.backend.entity.User;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.repositority.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {
    @Autowired
    private UserRepo repo;
    public User getById(Long id){
        Optional<User> users = repo.findById(id);
        if (users.isEmpty())throw new ApiException(ErrorMessage.ID_EXISTED);
        return users.get();
    }
}
