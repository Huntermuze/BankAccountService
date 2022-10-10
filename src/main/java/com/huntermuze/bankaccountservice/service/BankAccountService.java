package com.huntermuze.bankaccountservice.service;

import com.huntermuze.bankaccountservice.dto.BankAccount;
import com.huntermuze.bankaccountservice.dto.container.BankAccounts;
import com.huntermuze.bankaccountservice.exception.AlreadyExistException;
import com.huntermuze.bankaccountservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountService {
    BankAccounts getAllBankAccounts();

    BankAccount getBankAccount(String id) throws NotFoundException;

    void addBankAccount(BankAccount bankAccount) throws AlreadyExistException;

    void updateBankAccount(BankAccount bankAccount) throws NotFoundException;

    void deleteBankAccount(String id) throws NotFoundException;
}
