package com.huntermuze.bankaccountservice.repository;

import com.huntermuze.bankaccountservice.entity.BankAccountPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountPOJO, String> {
}
