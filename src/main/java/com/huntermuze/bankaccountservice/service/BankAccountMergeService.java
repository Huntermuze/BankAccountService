package com.huntermuze.bankaccountservice.service;

import com.huntermuze.bankaccountservice.dto.BankAccount;
import com.huntermuze.bankaccountservice.entity.BankAccountPOJO;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMergeService {
    public BankAccount bankAccountEntityToDTO(BankAccountPOJO bankAccountPOJO) {
        return new BankAccount(bankAccountPOJO.getAccountNumber(), bankAccountPOJO.getUserID(),
                bankAccountPOJO.getAccountType(), bankAccountPOJO.getAccountName(), bankAccountPOJO.getBalance());
    }

    public BankAccountPOJO bankAccountDTOToEntity(BankAccount bankAccount) {
        return new BankAccountPOJO(bankAccount.getAccountNumber(), bankAccount.getUserID(),
                bankAccount.getAccountType(), bankAccount.getAccountName(), bankAccount.getBalance());
    }
}
