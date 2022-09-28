package com.icheck.backend.repositority;

import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PacksResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface PackRepoCustom {
    public PacksResponse searchCustom(PackRequest request);
}
