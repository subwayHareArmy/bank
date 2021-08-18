package com.example.bank.controller;

import com.example.bank.data.AccountEntity;
import com.example.bank.dto.CreditRequest;
import com.example.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankingController {

    @Autowired
    private final AccountService accountService;

    @GetMapping("/banking/test")
    public ResponseEntity testing() {
        System.out.println("Testing Successful"); System.out.println("____________________");
        return new ResponseEntity<>("Test Successful", HttpStatus.OK);
    }

    @GetMapping("/banking/balance/{accountNumber}")
    public ResponseEntity getBalance(@PathVariable String accountNumber) {
        Double searched = accountService.getBalanceByAccountNumber(accountNumber);
        System.out.println("Getting balance of account number: " + accountNumber);
        if(searched == null){
            System.out.println("Could not find the account."); System.out.println("____________________");
            HttpHeaders headers = new HttpHeaders(); headers.add("reason", "No account with that account number exists");
            return new ResponseEntity<>("Could not find the account with account number: '" + accountNumber + "'", headers, HttpStatus.NOT_FOUND);
        }
        System.out.println("It is " + searched); System.out.println("____________________");
        return new ResponseEntity<>(searched, HttpStatus.OK);
    }

    @PostMapping(path = "/banking/credit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity credit(@Valid @RequestBody CreditRequest creditRequest, BindingResult bindingResult) {

        System.out.println("Received the following Crediting request: " + creditRequest);
        if (bindingResult.hasErrors()) {
            List<String> valErrors = new ArrayList<>();
            for (int i = 0; i < bindingResult.getErrorCount(); i++) {
                valErrors.add(bindingResult.getAllErrors().get(i).getDefaultMessage());
            }
            System.out.println(valErrors); System.out.println("____________________");
            return new ResponseEntity<>(valErrors, HttpStatus.BAD_REQUEST);
        }

        String accountNumber = creditRequest.getAccountNumber();
        AccountEntity accountById = accountService.getAccountByAccountNumber(accountNumber);
        if (accountById == null) {
            System.out.println("Account with the account number: " + accountNumber + " does not exist."); System.out.println("____________________");
            return new ResponseEntity<>("Account with the account number: " + accountNumber + " does not exist.", HttpStatus.BAD_REQUEST);
        }

        System.out.println("Previous Account balance was: " + accountById.getBalance() );
        accountById.setBalance(accountById.getBalance() + creditRequest.getAmount());
        System.out.println("Updated Account balance is: " + accountById.getBalance() ); System.out.println("____________________");
        AccountEntity updatedAccount = accountService.save(accountById);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @PostMapping(path = "/banking/newaccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAccount(@Valid @RequestBody AccountEntity accountEntity, BindingResult bindingResult ) {

        System.out.println("Received the following account creation request: " + accountEntity);
        if (bindingResult.hasErrors()){
            List<String> valErrors = new ArrayList<>();
            for(int i = 0; i < bindingResult.getErrorCount(); i++) {
                valErrors.add(bindingResult.getAllErrors().get(i).getDefaultMessage());
            }
            System.out.println(valErrors); System.out.println("____________________");
            return new ResponseEntity(valErrors, HttpStatus.BAD_REQUEST);
        }

        AccountEntity newAccount = accountService.save(accountEntity);
        if(newAccount == null) {
            System.out.println("Account with account number: " + accountEntity.getAccountNumber() + " already exists."); System.out.println("____________________");
            return new ResponseEntity<>("Account with account number: " + accountEntity.getAccountNumber() + " already exists.", HttpStatus.BAD_REQUEST);
        }
        System.out.println("Creating new account"); System.out.println(newAccount); System.out.println("____________________");
        return new ResponseEntity<>(newAccount, HttpStatus.OK);
    }

}
