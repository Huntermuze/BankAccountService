package com.huntermuze.bankaccountservice.entity;

import com.huntermuze.bankaccountservice.dto.AccountType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "BankAccount")
@Table(name = "BankAccount")
@EntityListeners(AuditingEntityListener.class)
public class BankAccountPOJO {
    @Id
    private String accountNumber;
    @Column(name = "user_id", nullable = false, unique = true)
    private long userID;
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;
    @Column(name = "account_name", nullable = false)
    private String accountName;
    @Column(name = "balance")
    private double balance;
    @Column(name = "date", nullable = false)
    @CreatedDate
    private Date date = new Date();

    public BankAccountPOJO(String accountNumber, long userID, AccountType accountType, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.userID = userID;
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = balance;
    }

    public BankAccountPOJO() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
