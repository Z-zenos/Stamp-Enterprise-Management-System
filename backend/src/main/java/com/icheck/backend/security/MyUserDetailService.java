package com.icheck.backend.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class MyUserDetailService implements UserDetailsService {
	
	// Khai báo userService
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// userService.findByUsername();
    	
    	// Có trả về thông tin , không thì bắn lỗi throw new UsernameNotFoundException();
    	
    	// Load from DB
        return new User("admin", "123", new ArrayList<>());
    }
}
