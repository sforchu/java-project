package com.safaew.home_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "homes")
@Getter
@Setter
public class HomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "street", nullable = false)
    private String street;


    @Column(name = "city", nullable = false)
    private String city;


    @Column(name = "state")
    private String state;


    @Column(name = "zip code", nullable = false)
    private String zipCode;


    @Column(name = "country")
    private String country;


    @Column(name = "total price", nullable = false)
    private Double totalPrice;

    @Column(name = "mortgage amount", nullable = false)
    private Double mortgageAmount;


    @Column(name = "interest rate", nullable = false)
    private Double interestRate;


    @Column(name = "loan duration", nullable = false)
    private Integer loanDuration;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(Double mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }
}
