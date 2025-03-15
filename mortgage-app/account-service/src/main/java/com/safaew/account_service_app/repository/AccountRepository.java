package com.safaew.account_service_app.repository;

import com.safaew.account_service_app.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// manages the AccountEntity allowing CRUD (create, Read, Update, and Delete) operations and
// other useful Jpa-related functionality
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
