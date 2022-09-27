package com.icheck.backend.converter;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import org.springframework.stereotype.Component;

@Component
public class PackConverter {
    public Pack toEntity (PackRequest packRequest){
        Pack pack = new Pack();

        pack.setQuantity(packRequest.getQuantity());
        pack.setName(packRequest.getName());
        pack.setCode(packRequest.getCode());
        pack.setPrice(packRequest.getPrice());
        pack.setStatus(packRequest.getStatus());
        return pack;
    }
    public PackResponse toResponse (Pack pack) {
        PackResponse packResponse = new PackResponse();

        packResponse.setId(pack.getId());
        packResponse.setName(pack.getName());
        packResponse.setCode(pack.getCode());
        packResponse.setPrice(pack.getPrice());
        packResponse.setStatus(pack.getStatus());
        packResponse.setQuantity(pack.getQuantity());
        packResponse.setCreateAt(pack.getCreatedAt());
        return packResponse;
    }
}
