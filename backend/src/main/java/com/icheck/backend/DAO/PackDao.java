package com.icheck.backend.DAO;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.repositority.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PackDao {
    @Autowired
    private PackRepo repo;

    public Pack getById(Long id){
        return repo.findById(id).get();
    }
}
