package com.safaew.account_service_app.controller;

import com.safaew.account_service_app.dto.AccountRequest;
import com.safaew.account_service_app.dto.AccountResponse;
import com.safaew.account_service_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AccountResponse>> getAllAccount() {
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.CREATED);
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("accountId") String accountId) {
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.CREATED);
    }



}
