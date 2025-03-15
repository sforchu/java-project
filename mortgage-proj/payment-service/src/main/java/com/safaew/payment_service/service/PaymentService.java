package com.safaew.payment_service.service;


import com.safaew.payment_service.dto.HomeResponse;
import com.safaew.payment_service.dto.PaymentRequest;
import com.safaew.payment_service.dto.PaymentResponse;
import com.safaew.payment_service.entity.PaymentTransactionEntity;
import com.safaew.payment_service.exception.ApplicationValidationException;
import com.safaew.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Value("${app.service.home-service}")
    private String homeServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse makePayment (PaymentRequest paymentRequest) {

        HomeResponse homeResponse = callHomeService(paymentRequest.getHomeId());

        if (paymentRequest.getAmount() < homeResponse.getMortgageAmount()) {
            throw new ApplicationValidationException("Amount must not be less than mortgage amount");
        }
        Double additionalAmount = paymentRequest.getAmount() - homeResponse.getMortgageAmount();

        Double interestAmount = (homeResponse.getInterestRate()/100) * homeResponse.getMortgageAmount();

        double balance = homeResponse.getTotalPrice() - homeResponse.getMortgageAmount() - interestAmount - additionalAmount;

        Optional<PaymentTransactionEntity> paymentTransactionEntityOptional = paymentRepository.findLatestPayment(paymentRequest.getHomeId());
        if (paymentTransactionEntityOptional.isPresent()) {
            PaymentTransactionEntity paymentTransactionEntity = paymentTransactionEntityOptional.get();

            balance =  paymentTransactionEntity.getBalance() - (homeResponse.getMortgageAmount() - interestAmount) - additionalAmount;
        }

        PaymentTransactionEntity paymentTransactionEntity = new PaymentTransactionEntity();

        paymentTransactionEntity.setAmount(homeResponse.getMortgageAmount());
        paymentTransactionEntity.setHomeId(paymentRequest.getHomeId());
        paymentTransactionEntity.setAdditionalAmount(additionalAmount);
        paymentTransactionEntity.setPaymentDate(LocalDateTime.now());
        paymentTransactionEntity.setInterestAmount(interestAmount);
        paymentTransactionEntity.setBalance(balance);
        paymentTransactionEntity.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(paymentTransactionEntity);

        PaymentResponse response = new PaymentResponse();
        response.setPaymentDate(paymentTransactionEntity.getPaymentDate());
        response.setAmount(paymentTransactionEntity.getAmount());
        response.setHomeId(paymentTransactionEntity.getHomeId());
        response.setInterestAmount(paymentTransactionEntity.getInterestAmount());
        response.setBalance(paymentTransactionEntity.getBalance());
        response.setAdditionalAmount(paymentTransactionEntity.getAdditionalAmount());




        return response;
    }



    public List<PaymentResponse> getPaymentBalance(String homeId) {
        return null;
    }


    private HomeResponse callHomeService(String homeId) {

        ResponseEntity<HomeResponse> account = restTemplate.getForEntity(homeServiceUrl +"/"+homeId, HomeResponse.class);

        return account.getBody();
    }

}
