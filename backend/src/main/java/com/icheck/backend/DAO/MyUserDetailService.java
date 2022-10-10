package com.icheck.backend.DAO;

import com.icheck.backend.converter.AdminConverter;
import com.icheck.backend.entity.Admin;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.repositority.AdminRepositority;
import com.icheck.backend.security.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Component("Admin")
public class MyUserDetailService implements UserDetailsService {
	
	// Khai báo userService
    @Autowired
    private AdminRepositority repo;
    @Autowired
    private AdminConverter converter;
    @Override
    public AdminAccount loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = repo.findByUserName(username);

        AdminAccount adminAccount = converter.toAdminAccount(admin);

        if (adminAccount == null) {
            throw new ApiException(ErrorMessage.INCORRECT_LOGIN);
        }
        return adminAccount;
    }
}
