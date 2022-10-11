package com.huntermuze.bankaccountservice.service;

import com.huntermuze.bankaccountservice.dto.BankAccount;
import com.huntermuze.bankaccountservice.dto.User;
import com.huntermuze.bankaccountservice.dto.container.BankAccounts;
import com.huntermuze.bankaccountservice.exception.AlreadyExistException;
import com.huntermuze.bankaccountservice.exception.InvalidIdException;
import com.huntermuze.bankaccountservice.exception.NotFoundException;
import com.huntermuze.bankaccountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    BankAccountMergeService bankAccountMergeService;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public BankAccounts getAllBankAccounts() {
        return new BankAccounts(bankAccountRepository.findAll().stream().map(pojo -> bankAccountMergeService.bankAccountEntityToDTO(pojo)).collect(Collectors.toList()));
    }

    @Override
    public BankAccount getBankAccount(String id) throws NotFoundException {
        var result = bankAccountRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(String.format("The bank account with account number %s was not found!", id));
        }
        return bankAccountMergeService.bankAccountEntityToDTO(result.get());
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) throws NotFoundException, AlreadyExistException {
        try {
            restTemplate.getForObject("http://localhost:8081/users/" + bankAccount.getUserID(), User.class);
        } catch (RestClientException e) {
            throw new NotFoundException(String.format("The user with id %s does not exist!", bankAccount.getUserID()));
        }
        var result = bankAccountRepository.findById(bankAccount.getAccountNumber());
        if (result.isPresent()) {
            throw new AlreadyExistException("This bank account already exists!");
        }
        bankAccountRepository.save(bankAccountMergeService.bankAccountDTOToEntity(bankAccount));
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) throws NotFoundException, NotFoundException {
        try {
            restTemplate.getForObject("http://localhost:8081/users/" + bankAccount.getUserID(), User.class);
        } catch (RestClientException e) {
            throw new NotFoundException(String.format("The user with id %s does not exist!", bankAccount.getUserID()));
        }
        var result = bankAccountRepository.findById(bankAccount.getAccountNumber());
        if (result.isEmpty()) {
            throw new NotFoundException(String.format("The bank account with account number %s was not found!", bankAccount.getAccountNumber()));
        }
        bankAccountRepository.save(bankAccountMergeService.bankAccountDTOToEntity(bankAccount));
    }

    @Override
    public void deleteBankAccount(String id) throws NotFoundException {
        var result = bankAccountRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(String.format("The bank account with account number %s was not found!", id));
        }
        bankAccountRepository.deleteById(id);
    }
}
