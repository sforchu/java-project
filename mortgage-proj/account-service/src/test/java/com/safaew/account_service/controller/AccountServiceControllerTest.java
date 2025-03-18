package com.safaew.account_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safaew.account_service.dto.AccountRequest;
import com.safaew.account_service.dto.AccountResponse;
import com.safaew.account_service.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
class AccountServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AccountService accountServiceMock;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllAccounts_shouldReturnListOfAccounts() throws Exception {
        List<AccountResponse> accounts = new ArrayList<>();
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setEmail("jpaul@gmail.com");
        accounts.add(accountResponse);

        when(accountServiceMock.getAllAccount()).thenReturn(accounts);

        RequestBuilder request = MockMvcRequestBuilders.get("/accounts").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();


        //assertEquals("[{\"id\":null,\"name\":null,\"email\":\"jpaul@gmail.com\"}]", contentAsString);
        JSONAssert.assertEquals("[{\"email\":\"jpaul@gmail.com\"}]", contentAsString, false);

        verify(accountServiceMock, times(1)).getAllAccount();

    }


    @Test
    public void getAccount_shouldReturnAccountById() throws Exception {

        // Prepare test
        AccountResponse account = new AccountResponse();
        account.setName("Paul");

        when(accountServiceMock.getAccount(anyString())).thenReturn(account);
        RequestBuilder request = MockMvcRequestBuilders.get("/accounts/2468").accept(MediaType.APPLICATION_JSON);

        // Execute test
        MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();

        // validate test
        verify(accountServiceMock).getAccount("2468");
        JSONAssert.assertEquals("{name:Paul}", mvcResult.getResponse().getContentAsString(), false);

    }

    @Test
    public void createAccount_shouldReturnCreatedAccount() throws Exception {


        // Prepare Test
        AccountRequest addAccounts = new AccountRequest();
        AccountResponse response = new AccountResponse();
        addAccounts.setName("James");
        response.setName("James");

        when(accountServiceMock.createAccount(any(AccountRequest.class))).thenReturn(response);
        RequestBuilder request = MockMvcRequestBuilders.post("/accounts")
                .content(objectMapper.writeValueAsString(addAccounts))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        // Execute Test
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(content().json("{name:James}"))
                .andExpect(status().isCreated())
                .andReturn();

        // Validate Test
        verify(accountServiceMock, times(1)).createAccount(any(AccountRequest.class));
        //JSONAssert.assertEquals("{name:James}", mvcResult.getResponse().getContentAsString(), false);
    }
}