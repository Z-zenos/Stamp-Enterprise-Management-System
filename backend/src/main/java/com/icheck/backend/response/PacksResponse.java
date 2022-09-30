package com.icheck.backend.response;

import com.icheck.backend.entity.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class PacksResponse {
    private List<PackResponse> packList;
    public PacksResponse(){
        packList = new ArrayList<>();
    }
}
