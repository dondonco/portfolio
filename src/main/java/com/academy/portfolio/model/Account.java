package com.academy.portfolio.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularAccount.class, name="regular"),
        @JsonSubTypes.Type(value = CheckingAccount.class, name = "checking"),
        @JsonSubTypes.Type(value = InterestAccount.class, name = "interest")
})
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String acctNumber;
    private double balance;
    private double minimumBalance;
    private double penalty;
    private double transactionCharge;
    private double interestCharge;

    public Double transaction(String transaction, double amount){
        double tempBalance = (transaction.equals("deposit") ? this.balance + amount : this.balance - amount) - this.transactionCharge;
        this.balance = tempBalance >= this.minimumBalance ? tempBalance : tempBalance - this.penalty;
        return this.balance;
    }

    public String generateAccountNumber(){
        String temp = "";
        Random random = new Random();
        for(int i = 0; i < 16; i++){
            temp += random.nextInt(9);
        }
        return temp;
    }
}
