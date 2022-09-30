package com.icheck.backend.converter;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PackConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Pack toEntity (PackRequest packRequest){
        Pack pack = modelMapper.map(packRequest, Pack.class);
        return pack;
    }
    public PackResponse toResponse (Pack pack) {
        PackResponse packResponse = modelMapper.map(pack, PackResponse.class);
        return packResponse;
    }
}
