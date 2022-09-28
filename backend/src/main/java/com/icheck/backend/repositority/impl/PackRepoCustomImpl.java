package com.icheck.backend.repositority.impl;

import com.icheck.backend.converter.PackConverter;
import com.icheck.backend.entity.Pack;
import com.icheck.backend.repositority.PackRepo;
import com.icheck.backend.repositority.PackRepoCustom;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PacksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class PackRepoCustomImpl implements PackRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PackConverter packConverter;
    @Override
    public PacksResponse searchCustom(PackRequest request) {
        PacksResponse packsResponse = new PacksResponse();
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append("select * from pack p where p.code LIKE :code and p.name LIKE :name ");
        params.put("code", "%"+request.getCode()+"%");
        params.put("name", "%"+request.getName()+"%");

        if (request.getStatus() != -1){
            sql.append("and status = :status");
            params.put("status", request.getStatus());
        }
        Query query = entityManager.createNativeQuery(sql.toString(), Pack.class);
        params.forEach(query::setParameter);
        List<Pack> packList =  query.getResultList();
        for (Pack pack:packList) {
            packsResponse.getPackList().add(packConverter.toResponse(pack));
        }
        return packsResponse;
    }
}
