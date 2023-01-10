package com.academy.portfolio.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class CheckingAccount extends Account{
    public CheckingAccount(String name){
        this.setName(name);
        this.setMinimumBalance(100);
        this.setBalance(100);
        this.setPenalty(10);
        this.setTransactionCharge(1);
        this.setAcctNumber(this.generateAccountNumber());
    }
}
