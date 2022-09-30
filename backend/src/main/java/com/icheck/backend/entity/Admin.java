package com.icheck.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String userName;

    @Column(length = 100)
    private String password;

    @Column(length = 50)
    private String name;

    @Column(length = 11)
    private String phone;

    @Column(length = 100)
    private String email;
}
