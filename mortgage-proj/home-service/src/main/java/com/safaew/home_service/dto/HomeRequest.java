package com.safaew.home_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// To create, get, update and delete a home, we make use of the HomeRequest,
// where you provide the below infos
public class HomeRequest {

    @NotBlank(message = "street is required")
    @Size(min = 5, max = 100, message = "street should be between 5-100 characters")
    private String street;

    @NotBlank(message = "city is required")
    @Size(min = 5, max = 20, message = "city should be between 5-20 characters")
    private String city;

    @NotBlank(message = "state is required")
    @Size(min = 5, max = 20, message = "state should be between 5-20 characters")
    private String state;


    @NotBlank(message = "zip code is required")
    @Size(min = 5, max = 20, message = "zip code should be between 5-20 characters")
    private String zipCode;


    @NotBlank(message = "country is required")
    @Size(min = 5, max = 20, message = "country should be between 5-20 characters")
    private String country;

    @NotNull(message = "total price is required")
    private Double totalPrice;

    @NotNull(message = "mortgage amount is required")
    private Double mortgageAmount;

    @NotNull(message = "interest rate is required")
    private Double interestRate;

    @NotNull(message = "loan duration is required")
    private Integer loanDuration;


    @NotNull(message = "Account Id must be provided")
    private String accountId;

    public @NotBlank(message = "street is required") @Size(min = 5, max = 100, message = "street should be between 5-100 characters") String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank(message = "street is required") @Size(min = 5, max = 100, message = "street should be between 5-100 characters") String street) {
        this.street = street;
    }

    public @NotBlank(message = "city is required") @Size(min = 5, max = 20, message = "city should be between 5-20 characters") String getCity() {
        return city;
    }

    public void setCity(@NotBlank(message = "city is required") @Size(min = 5, max = 20, message = "city should be between 5-20 characters") String city) {
        this.city = city;
    }

    public @NotBlank(message = "state is required") @Size(min = 5, max = 20, message = "state should be between 5-20 characters") String getState() {
        return state;
    }

    public void setState(@NotBlank(message = "state is required") @Size(min = 5, max = 20, message = "state should be between 5-20 characters") String state) {
        this.state = state;
    }

    public @NotBlank(message = "zip code is required") @Size(min = 5, max = 20, message = "zip code should be between 5-20 characters") String getZipCode() {
        return zipCode;
    }

    public void setZipCode(@NotBlank(message = "zip code is required") @Size(min = 5, max = 20, message = "zip code should be between 5-20 characters") String zipCode) {
        this.zipCode = zipCode;
    }

    public @NotBlank(message = "country is required") @Size(min = 5, max = 20, message = "country should be between 5-20 characters") String getCountry() {
        return country;
    }

    public void setCountry(@NotBlank(message = "country is required") @Size(min = 5, max = 20, message = "country should be between 5-20 characters") String country) {
        this.country = country;
    }

    public @NotNull(message = "total price is required") Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@NotNull(message = "total price is required") Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public @NotNull(message = "mortgage amount is required") Double getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(@NotNull(message = "mortgage amount is required") Double mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public @NotNull(message = "interest rate is required") Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(@NotNull(message = "interest rate is required") Double interestRate) {
        this.interestRate = interestRate;
    }

    public @NotNull(message = "loan duration is required") Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(@NotNull(message = "loan duration is required") Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public @NotNull(message = "Account Id must be provided") String getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull(message = "Account Id must be provided") String accountId) {
        this.accountId = accountId;
    }
}
