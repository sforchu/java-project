package com.safaew.payment_service.repository;

import com.safaew.payment_service.entity.PaymentTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentTransactionEntity, String> {

   // @Query(value = "Select * from transactions t1 where payment_date = (select max(t2.payment_date) from transactions t2) and txn.homeId=:homeId ", nativeQuery = true)


    //jpa query using entities rather than regular query which makes use of tables as above
    //@Query(value = "Select txn from PaymentTransactionEntity txn order by txn.paymentDate desc limit 1")

    @Query(value = "Select txn from PaymentTransactionEntity txn WHERE txn.paymentDate = (select max(txn2.paymentDate) FROM PaymentTransactionEntity txn2) and txn.homeId=:homeId")
    Optional<PaymentTransactionEntity> findLatestPayment(String homeId);
}
