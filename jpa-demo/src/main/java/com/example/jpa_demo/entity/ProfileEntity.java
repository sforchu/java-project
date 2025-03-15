package com.example.jpa_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToOne(mappedBy = "profile")
    private UserEntity user;



}
