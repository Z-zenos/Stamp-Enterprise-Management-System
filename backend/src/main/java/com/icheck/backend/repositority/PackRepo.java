package com.icheck.backend.repositority;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PacksResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepo extends JpaRepository<Pack, Long> {

}
