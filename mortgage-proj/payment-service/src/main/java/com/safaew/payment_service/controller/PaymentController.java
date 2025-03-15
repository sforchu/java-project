package com.safaew.payment_service.controller;

import com.safaew.payment_service.dto.PaymentRequest;
import com.safaew.payment_service.dto.PaymentResponse;
import com.safaew.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<PaymentResponse> makePaymentTransaction(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.makePayment(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);

    }

    @GetMapping("/{homeId}")
    public ResponseEntity<List<PaymentResponse>> getHomePaymentBalance(@PathVariable("homeId") String homeId) {
        List<PaymentResponse> paymentResponse = paymentService.getPaymentBalance(homeId);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
