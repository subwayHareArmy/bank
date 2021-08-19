package com.example.bank.service;

import com.example.bank.data.AccountEntity;
import com.example.bank.dto.Account;
import com.example.bank.repository.AccountRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Searches AccountEntity object if it exists, by account number
    public AccountEntity getAccountByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    // Saves an account to database. If it already exists, it is overwritten
    public AccountEntity save(AccountEntity newAccount){
        return accountRepository.save(newAccount);
    }

    // Returns the balance of an account if it exists
    public Double getBalanceByAccountNumber(String accountNumber){
        AccountEntity temp = accountRepository.findByAccountNumber(accountNumber);
        if (temp == null) {
            return null;
        }
        return temp.getBalance();
    }

}
