package com.academy.portfolio.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class RegularAccount extends Account{
    public RegularAccount(String name){
        this.setName(name);
        this.setMinimumBalance(500);
        this.setBalance(500);
        this.setPenalty(10);
        this.setAcctNumber(this.generateAccountNumber());
    }
}
