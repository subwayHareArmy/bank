package com.example.bank.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// Check if noArgs Constructor is even needed
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Account number cannot be null.")
    private String accountNumber;

    @NotNull(message = "Account name cannot be null.")
    private String name;

    private String address;

    private String ifsc;

    @NotNull(message = "Account balance cannot be null.")
    private Double balance;

}
