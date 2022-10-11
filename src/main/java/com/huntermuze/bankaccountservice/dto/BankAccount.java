package com.huntermuze.bankaccountservice.dto;

import java.util.Date;

public class BankAccount {
    private String accountNumber;
    private long userID;
    private AccountType accountType;
    private String accountName;
    private double balance;

    public BankAccount(String accountNumber, long userID, AccountType accountType, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.userID = userID;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
