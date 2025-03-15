package com.safaew.account_service_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

// To create, get, update and delete an account, we make use of the AccountRequest,
// where you provide your name and email
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {

    @NotBlank(message = "name is required")
    @Size(min = 4, max = 50, message = "Name must be between 4 - 50 characters")
    private String name;


    @Email(message = "email is invalid")
    @NotBlank(message = "email is required")
    private String email;


    public @NotBlank(message = "name is required") @Size(min = 4, max = 50, message = "Name must be between 4 - 50 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name is required") @Size(min = 4, max = 50, message = "Name must be between 4 - 50 characters") String name) {
        this.name = name;
    }

    public @Email(message = "email is invalid") @NotBlank(message = "email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "email is invalid") @NotBlank(message = "email is required") String email) {
        this.email = email;
    }
}
