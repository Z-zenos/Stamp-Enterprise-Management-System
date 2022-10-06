package com.icheck.backend.repositority;

import com.icheck.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public List<User> findByEmail(String email);

    public List<User> findByPhone(String phone);

    public List<User> findByTaxCode(String taxCode);
}
