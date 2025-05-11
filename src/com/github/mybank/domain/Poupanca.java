package com.github.mybank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Poupanca extends Conta {

    public Poupanca(long accountNumber, int agency) {
        super(accountNumber, agency);
    }

    @Override
    public void deposit(BigDecimal value) {
        Objects.requireNonNull(value, "Valor não pode ser nulo.");

        if(value.compareTo(BigDecimal.valueOf(100)) < 0){
            throw new IllegalArgumentException("O valor inserido deve ser no mínimo igual a R$100,00 para deposito.");
        }

        depositAmount(value);
    }

    @Override
    public void withdraw(BigDecimal value) {
        Objects.requireNonNull(value, "O valor não pode ser nulo.");

        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(String.format("Valor do saque (R$ %,.2f) deve ser positivo", value));
        }

        if(getBalance().compareTo(BigDecimal.valueOf(50)) <= 0){
            throw new IllegalStateException(
                    String.format("Você não pode sacar (R$%,.2f) porque o saldo de sua conta é menor ou igual a 50.\nSaldo atual: R$%,.2f",
                    value, getBalance())
            );
        }

        subtractAmount(value);
    }

    @Override
    protected void validateTransfer(BigDecimal value, Conta recipient){
        super.validateTransfer(value, recipient);
        if(recipient instanceof Poupanca){
            throw new IllegalArgumentException("Não pode haver transferências entre contas poupanças.");
        }

        if(getBalance().subtract(value).compareTo(BigDecimal.valueOf(50)) <= 0){
            throw new RuntimeException("Saldo não pode ficar abaixo de R$ 50,00");
        }
    }
}
