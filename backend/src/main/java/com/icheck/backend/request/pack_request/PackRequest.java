package com.icheck.backend.request.pack_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackRequest {
    private Long id;
    private String code;
    private String name;
    private int quantity;
    private double price;
    private int status;
}
