package com.example.jpa_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // tells java you want to map to Db
@Table(name = "persons")
//@Data
public class PersonEntity {

    @Id
    @Column(name = "person_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "fname")
    private String firstname;

    @Column(name = "lname", nullable = false)
    private String lastname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
