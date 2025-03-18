package com.safaew.account_service.repository;

import com.safaew.account_service.entity.AccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void accountRepositoryTest () {
        List<AccountEntity> accounts = accountRepository.findAll();
        assertEquals(1, accounts.size());
        assertEquals("Jules", accounts.get(0).getName());

    }
}
