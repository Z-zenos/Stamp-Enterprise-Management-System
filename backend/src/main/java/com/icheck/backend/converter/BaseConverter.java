package com.icheck.backend.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BaseConverter {
    @Autowired
    private ModelMapper modelMapper;
//    public <S, D> D toEntity (S src, D destination){
//        modelMapper.map(src, destination);
//        return destination;
//    }
//    }
    public <T, D> D toEntity(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
    public <T, D> D toResponse (T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}
