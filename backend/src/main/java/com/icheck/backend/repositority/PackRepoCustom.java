package com.icheck.backend.repositority;

import com.icheck.backend.response.pack_response.PacksResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepoCustom {
    public PacksResponse search(String code, String name, int status);
}
