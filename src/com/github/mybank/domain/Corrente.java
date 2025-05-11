package com.github.mybank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Corrente extends Conta{

    public Corrente(long accountNumber, int agency) {
        super(accountNumber, agency);
    }

    @Override
    public void deposit(BigDecimal value){
        Objects.requireNonNull(value, "Valor não pode ser nulo.");

        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Para depositar, o valor deve ser maior que 0.");
        }

        depositAmount(value);
    }

    @Override
    public void withdraw(BigDecimal value) {
        Objects.requireNonNull(value, "Valor não pode ser nulo.");

        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(
                    String.format("Valor do saque (R$ %,.2f) deve ser positivo", value)
            );
        }

        if(value.compareTo(getBalance()) > 0){
            throw new IllegalStateException(String.format("Saldo insuficiente. Disponível: R$ %,.2f | Tentativa: R$ %,.2f",
                    getBalance(), value));
        }

        subtractAmount(value);
    }
}
