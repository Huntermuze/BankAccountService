package com.huntermuze.bankaccountservice.controller;

import com.huntermuze.bankaccountservice.dto.BankAccount;
import com.huntermuze.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bankaccounts")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @GetMapping
    public ResponseEntity<Object> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> getBankAccount(@PathVariable("accountNumber") String accountNumber) {
        return ResponseEntity.ok(bankAccountService.getBankAccount(accountNumber));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.addBankAccount(bankAccount);
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(bankAccount.getAccountNumber())
                .toUri();
        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.updateBankAccount(bankAccount);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{accountNumber}")
    public ResponseEntity<Object> deleteBankAccount(@PathVariable("accountNumber") String accountNumber) {
        bankAccountService.deleteBankAccount(accountNumber);
        return ResponseEntity.ok().build();
    }
}
