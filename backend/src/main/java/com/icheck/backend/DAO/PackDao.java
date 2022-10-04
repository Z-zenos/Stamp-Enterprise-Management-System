package com.icheck.backend.DAO;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.repositority.PackRepo;
import com.icheck.backend.response.PackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class PackDao {
    @Autowired
    private PackRepo repo;

    public Pack getById(Long id){
        return repo.findById(id).get();
    }
}
