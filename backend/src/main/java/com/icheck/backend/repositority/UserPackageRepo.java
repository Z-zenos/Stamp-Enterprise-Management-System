package com.icheck.backend.repositority;

import com.icheck.backend.entity.UserPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPackageRepo extends JpaRepository<UserPackage, Long> {
    List<UserPackage> findByUserIdAndPackageId(Long userId, Long packId);
}
