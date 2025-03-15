package com.safaew.payment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    @NotBlank(message = "homeId is required")
    private String homeId;

    @NotNull(message = "amount is required")
    private Double amount;


//    @NotNull(message = "")
//    public Double getAdditionalAmount;

    public @NotBlank(message = "homeId is required") String getHomeId() {
        return homeId;
    }

//    public @NotNull(message = "") Double getGetAdditionalAmount() {
//        return getAdditionalAmount;
//    }
//
//    public void setGetAdditionalAmount(@NotNull(message = "") Double getAdditionalAmount) {
//        this.getAdditionalAmount = getAdditionalAmount;
//    }

    public void setHomeId(@NotBlank(message = "homeId is required") String homeId) {
        this.homeId = homeId;
    }

    public @NotNull(message = "amount is required") Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "amount is required") Double amount) {
        this.amount = amount;
    }
}
