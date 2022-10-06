package com.icheck.backend.response.pack_response;

import com.icheck.backend.response.pack_response.PackResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

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
