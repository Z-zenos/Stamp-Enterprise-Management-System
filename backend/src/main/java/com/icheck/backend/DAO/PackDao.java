package com.icheck.backend.DAO;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.repositority.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PackDao {
    @Autowired
    private PackRepo repo;

    public Pack getById(Long id){
        Optional<Pack> packOptional =  repo.findById(id);
        if (packOptional.isEmpty())throw new ApiException(ErrorMessage.ID_EXISTED);
        return packOptional.get();
    }
}
