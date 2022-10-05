package com.icheck.backend.security;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class AdminAccount extends User {
    private Long id;
    public AdminAccount(String userName, String password, ArrayList role) {
        super(userName, password, role);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
