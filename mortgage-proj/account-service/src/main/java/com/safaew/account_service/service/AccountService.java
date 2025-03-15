package com.safaew.account_service.service;

import com.safaew.account_service.dto.AccountRequest;

import com.safaew.account_service.dto.AccountResponse;
import com.safaew.account_service.entity.AccountEntity;
import com.safaew.account_service.exception.ResourceNotFoundException;
import com.safaew.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    // here we Autowire the AccountRepository cuz it manages the AccountEntity, that way we can easily
    // createAccount for example making use of the AccountEntity.
    private AccountRepository accountRepository;

    public AccountResponse createAccount(AccountRequest accountRequest) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(accountRequest.getName());
        accountEntity.setEmailAddress(accountRequest.getEmail());
        AccountEntity saveAccount = accountRepository.save(accountEntity);

        return mapAccountResponse(saveAccount);
    }

    public List<AccountResponse> getAllAccount() {

        List<AccountEntity> accounts = accountRepository.findAll();

        List<AccountResponse> response = new ArrayList<>();
        for (AccountEntity acc: accounts) {
            response.add(mapAccountResponse(acc));
        }
        return response;
    }


    public AccountResponse getAccount(String id) {

        Optional<AccountEntity> accountEntityOptional = accountRepository.findById(id);
        if (accountEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Account Not Found");
        }
        return mapAccountResponse(accountEntityOptional.get());
    }

    private AccountResponse mapAccountResponse(AccountEntity accountEntity) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(accountEntity.getId());
        accountResponse.setName(accountEntity.getName());
        accountResponse.setEmail(accountEntity.getEmailAddress());

        return accountResponse;
    }




}
