package com.icheck.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "package_service")
public class PackageService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column(length = 100)
    private String name;

    @Column
    private int quantity;

    @Column
    private double price;

    @Column
    private LocalDateTime created_at;

    @Column
    private int status;

}
