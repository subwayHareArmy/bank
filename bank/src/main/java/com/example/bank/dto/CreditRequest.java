package com.example.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Class for crediting requests
public class CreditRequest {

    @NotNull(message = "The parameter 'accountNumber' in the credit request body cannot be null.")
    private String accountNumber;

    // @Min and @Max annotations don't work on variables of type double. We need to use these annotations:
    @DecimalMin(value = "10.0", message = "Minimum amount to be credited cannot be less than 10 rupees.")
    @DecimalMax(value = "100000.0", message = "Maximum amount to be credited cannot be more than 1 lakh rupees.")
    private Double amount;

}
