package com.example.jpa_demo.repository;

import com.example.jpa_demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {


}
