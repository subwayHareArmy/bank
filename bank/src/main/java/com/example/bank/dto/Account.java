package com.example.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// This class does not get used as of now
public class Account {

    private Integer id;

    private String name;

    private String address;

    private String ifsc;

    private Double balance;

}
