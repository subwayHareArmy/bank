package com.example.bank.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Check if noArgs Constructor is even needed
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AccountEntity {

    // This is the primary key for the 'ACCOUNT_ENTITY' table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Account Numbers are only 10 digits
    @NotNull(message = "Account number cannot be null.")
    @Size(message = "Account number has to be exactly 10 digits.", min = 10, max = 10)
    private String accountNumber;

    @NotNull(message = "Account name cannot be null.")
    private String name;

    private String address;

    private String ifsc;

    @NotNull(message = "Account balance cannot be null.")
    @DecimalMin(value = "100.0", message = "Minimum amount balance needs to be 100.0 rupees.")
    private Double balance;

}
