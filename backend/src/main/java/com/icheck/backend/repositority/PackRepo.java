package com.icheck.backend.repositority;

import com.icheck.backend.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepo extends JpaRepository<Pack, Long> {

    public Pack findByCode(String code);
}
