package com.example.bank.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    // Account Numbers are only 10 digits, numerical strings
    @NotNull(message = "Account number cannot be null.")
    @Size(message = "Account number has to be exactly 10 digits.", min = 10, max = 10)
    @Pattern(regexp = "[0-9]+", message = "Account number can include only numbers.")
    private String accountNumber;

    // Account name can only have alphabets, no numeric or special characters
    @NotNull(message = "Account name cannot be null.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Account name can include only letters.")
    private String name;

    private String address;

    private String ifsc;

    @NotNull(message = "Account balance cannot be null.")
    @DecimalMin(value = "100.0", message = "Minimum amount balance needs to be 100.0 rupees.")
    private Double balance;

}
