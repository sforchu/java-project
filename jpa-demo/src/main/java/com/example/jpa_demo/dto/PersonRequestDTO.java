package com.example.jpa_demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PersonRequestDTO {


    //use @NotBlank only for String and use @NotNull for objects like local date
    @NotBlank(message = "fullNmae is required")
    @Size(min = 3, max = 20, message = "fullName must be btw 3 to 20 characters!")
    private String fullName;

    @NotNull(message = "dob is required")
    private LocalDate dob;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
