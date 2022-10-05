package com.icheck.backend.converter;

import com.icheck.backend.entity.Admin;
import com.icheck.backend.security.AdminAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AdminConverter {
    public AdminAccount toAdminAccount (Admin admin) {
        AdminAccount adminAccount = new AdminAccount(admin.getUserName(), admin.getPassword(),  new ArrayList<>());
        adminAccount.setId(admin.getId());
        return adminAccount;
    }
}
