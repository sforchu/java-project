package com.example.jpa_demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class CoursesEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "course_code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students = new ArrayList<>();

}
