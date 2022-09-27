package com.icheck.backend.service;

import com.icheck.backend.converter.PackConverter;
import com.icheck.backend.entity.Pack;
import com.icheck.backend.repositority.PackRepo;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import com.icheck.backend.response.PacksResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PackConverter packConverter;

    public PackResponse save(PackRequest packRequest) {
        Pack pack = packConverter.toEntity(packRequest);
        if (packRequest.getId() != null)pack.setId(packRequest.getId());
        try {
            packRepo.save(pack);
            return packConverter.toResponse(pack);
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            packRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.getStackTrace();
            return false;
        }
    }
    public PacksResponse getByCodeAndName(String code, String name) {
        PacksResponse packsResponse = new PacksResponse();

        List<Pack> packList = packRepo.findByCodeAndName(code, name);

        for(Pack pack : packList){
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }

    public PacksResponse findPagination(Pageable pageable) {
        PacksResponse packsResponse = new PacksResponse();

        Page<Pack> packList = packRepo.findAll(pageable);

        for(Pack pack : packList){
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }

    public PacksResponse getByName(String name) {
        PacksResponse packsResponse = new PacksResponse();

        List<Pack> packList = packRepo.findByName(name);

        for(Pack pack : packList){
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }

    public PacksResponse getByCode(String code) {
        PacksResponse packsResponse = new PacksResponse();

        List<Pack> packList = packRepo.findByCode(code);

        for(Pack pack : packList){
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }

    public PacksResponse getAll() {
        PacksResponse packsResponse = new PacksResponse();

        List<Pack> packList = packRepo.findAll();

        for(Pack pack : packList){
            System.out.println("createAt :"+pack.getCreatedAt());
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }
}
