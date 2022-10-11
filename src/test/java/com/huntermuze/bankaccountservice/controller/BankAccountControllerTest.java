package com.huntermuze.bankaccountservice.controller;

import com.huntermuze.bankaccountservice.dto.AccountType;
import com.huntermuze.bankaccountservice.dto.BankAccount;
import com.huntermuze.bankaccountservice.dto.container.BankAccounts;
import com.huntermuze.bankaccountservice.service.BankAccountService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BankAccountControllerTest {

    @MockBean
    private BankAccountService bankAccountService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllBankAccountsTest() throws Exception {
        // given
        List<BankAccount> accountsList = List.of(
                new BankAccount("123456", 12, AccountType.Loan, "Jane Wendy", 53013.12),
                new BankAccount("84814", 91, AccountType.Saving, "Timothy Duckling", 2154.32));
        BankAccounts bankAccounts = new BankAccounts(accountsList);
        // when
        bankAccountService.getAllBankAccounts();
        Mockito.when(bankAccountService.getAllBankAccounts()).thenReturn(bankAccounts);
        // then
        Mockito.verify(bankAccountService).getAllBankAccounts();
        mockMvc.perform(MockMvcRequestBuilders.get("/bankaccounts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bankAccountList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bankAccountList[0].accountNumber", Matchers.is("123456")));
    }

    @Test
    public void getBankAccountTest() throws Exception {
        // given
        String accNumber = "123456";
        BankAccount bankAccount = new BankAccount(accNumber, 12, AccountType.Loan, "Jane Wendy", 53013.12);
        // when
        bankAccountService.getBankAccount(accNumber);
        Mockito.when(bankAccountService.getBankAccount(accNumber)).thenReturn(bankAccount);
        // then
        Mockito.verify(bankAccountService).getBankAccount(accNumber);
        mockMvc.perform(MockMvcRequestBuilders.get("/bankaccounts/{accountNumber}", accNumber))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber", Matchers.is("123456")));
    }

    @Test
    public void deleteBankAccountTest() throws Exception {
        // given
        String accNumber = "123456";
        // when
        bankAccountService.deleteBankAccount(accNumber);
        // then
        Mockito.verify(bankAccountService).deleteBankAccount(accNumber);
        mockMvc.perform(MockMvcRequestBuilders.delete("/bankaccounts/{accountNumber}", accNumber))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
