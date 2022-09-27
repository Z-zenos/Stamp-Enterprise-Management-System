package com.icheck.backend.repositority;

import com.icheck.backend.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepo extends JpaRepository<Pack, Long> {
    @Query(nativeQuery = true, value = "select * from pack where code LIKE %:code% and name LIKE %:name%")
    List<Pack> findByCodeAndName(String code, String name);
    @Query(nativeQuery = true, value = "select * from pack where code LIKE %:code%")
    List<Pack> findByCode(String code);
    @Query(nativeQuery = true, value = "select * from pack where name LIKE %:name%")
    List<Pack> findByName(String name);
}
