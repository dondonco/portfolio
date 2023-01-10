package com.academy.portfolio.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class InterestAccount extends Account{
    public InterestAccount(String name){
        this.setName(name);
        this.setInterestCharge(3);
        this.setAcctNumber(this.generateAccountNumber());
    }
}
