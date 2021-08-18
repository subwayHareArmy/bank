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

    public AccountEntity getAccountByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public AccountEntity save(AccountEntity newAccount){
        AccountEntity temp = getAccountByAccountNumber(newAccount.getAccountNumber());
        if (temp == null){
            return accountRepository.save(newAccount);
        }
        return null;
    }

    public Double getBalanceByAccountNumber(String accountNumber){
        AccountEntity temp = accountRepository.findByAccountNumber(accountNumber);
        if (temp == null) {
            return null;
        }
        return temp.getBalance();
    }

}
