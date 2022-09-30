package com.icheck.backend.repositority;

import com.icheck.backend.request.UserRequest;
import com.icheck.backend.response.UsersResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoCustom {
    public UsersResponse search(UserRequest request);
}
