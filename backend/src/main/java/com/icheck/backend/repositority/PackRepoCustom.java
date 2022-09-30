package com.icheck.backend.repositority;

import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PacksResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PackRepoCustom {
    public PacksResponse search(PackRequest request);
}
