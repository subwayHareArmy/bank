package com.example.bank.repository;

import com.example.bank.data.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByAccountNumber(String accountNumber);

}
