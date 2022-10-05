package com.icheck.backend.service;

import com.icheck.backend.repositority.UserPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPackageService {
    @Autowired
    private UserPackageRepo repo;

}
