package com.icheck.backend.DAO;

import com.icheck.backend.entity.User;
import com.icheck.backend.repositority.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private UserRepo repo;
    public User getById(Long id){
        return repo.findById(id).get();
    }
}
