package com.icheck.backend.service;

import com.icheck.backend.converter.PackConverter;
import com.icheck.backend.entity.Pack;
import com.icheck.backend.repositority.PackRepo;
import com.icheck.backend.repositority.PackRepoCustom;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import com.icheck.backend.response.PacksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PackService {
    @Autowired
    private PackRepo packRepo;
    @Qualifier("packRepoCustom")
    @Autowired
    private PackRepoCustom packRepoCustom;
    @Autowired
    private PackConverter packConverter;

    public PackResponse delete(Pack pack) {
        try {
            packRepo.delete(pack);
            return packConverter.toResponse(pack);
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public PackResponse getById(Long id) {
        return packConverter.toResponse(packRepo.findById(id).get());
    }

    public PackResponse save(PackRequest packRequest) {
        Pack pack = packConverter.toEntity(packRequest);
        try{
            packRepo.save(pack);
            return packConverter.toResponse(pack);
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public PacksResponse search(String code, String name, int status) {
        return packRepoCustom.search(code, name, status);
    }
}
