package com.github.mybank.domain;

import java.math.BigDecimal;

public abstract class Conta extends ClientInformation{

    private long accountNumber;
    private int agency;
    private BigDecimal balance;

    public Conta(long accountNumber, int agency){
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = BigDecimal.valueOf(0);
    }


}
