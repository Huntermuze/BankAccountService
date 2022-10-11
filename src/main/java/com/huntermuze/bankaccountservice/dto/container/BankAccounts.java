package com.huntermuze.bankaccountservice.dto.container;

import com.huntermuze.bankaccountservice.dto.BankAccount;

import java.util.List;

public record BankAccounts(List<BankAccount> bankAccountList) {
}
