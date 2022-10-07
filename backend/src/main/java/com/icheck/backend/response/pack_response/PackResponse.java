package com.icheck.backend.response.pack_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackResponse {
    private Long id;
    private String code;
    private String name;
    private int quantity;
    private double price;
    private int status;
    private LocalDateTime createdAt;
}
