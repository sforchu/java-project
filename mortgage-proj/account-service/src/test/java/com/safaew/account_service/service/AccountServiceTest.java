package com.safaew.account_service.service;


import com.safaew.account_service.dto.AccountRequest;
import com.safaew.account_service.dto.AccountResponse;
import com.safaew.account_service.entity.AccountEntity;
import com.safaew.account_service.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Captor
    private ArgumentCaptor<AccountEntity> accountEntityArgumentCaptor;


    @Test
    public void createAccount_shouldReturnAccountCreated() {

        // Prepare test
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setName("Peter");

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(accountRequest.getName());


        when(accountRepository.save(any(AccountEntity.class))).thenReturn(accountEntity);


        // Execute Test
        AccountResponse response = accountService.createAccount(accountRequest);

        // Validate Test
        verify(accountRepository, times(1)).save(accountEntityArgumentCaptor.capture());
        assertEquals(accountRequest.getName(), response.getName());
        assertEquals(accountRequest.getName(), accountEntityArgumentCaptor.getValue().getName());
    }


    @Test
    public void getAllAccount_ShouldReturnAllAccountsCreated() throws Exception {


    }
}
