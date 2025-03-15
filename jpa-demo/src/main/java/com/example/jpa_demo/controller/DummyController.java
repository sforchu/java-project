package com.example.jpa_demo.controller;


import com.example.jpa_demo.entity.DepartmentEntity;
import com.example.jpa_demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/dummy")
    public void dummy(){

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setCode("CS");
        departmentEntity.setName("Computer Science");


//        DepartmentEntity departmentEntity2 = new DepartmentEntity();
//        departmentEntity.setCode("FS");
//        departmentEntity.setName("Science");

        departmentRepository.save(departmentEntity);


    }


}
