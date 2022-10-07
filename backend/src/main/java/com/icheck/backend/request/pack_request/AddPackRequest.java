package com.icheck.backend.request.pack_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddPackRequest {
    private String code;
    private String name;
    private int quantity;
    private double price;
}
