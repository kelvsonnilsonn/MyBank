package com.github.mybank.domain;

import com.github.mybank.domain.clientinformation.ClientInformation;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta{

    protected final long accountNumber;
    protected final int agency;
    protected ClientInformation clientInformation;
    private BigDecimal balance;

    public Conta(long accountNumber, int agency){
        if(accountNumber <= 0) throw new IllegalArgumentException("Número da conta está inválido.");
        if(agency <= 0) throw new IllegalArgumentException("Número da agência está invalido.");
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = BigDecimal.ZERO;
    }

    public void setClientInformation(ClientInformation clientInformation) { this.clientInformation = clientInformation; }

    public void setBalance(BigDecimal amount) { this.balance = amount; }

    public BigDecimal getBalance() { return this.balance; }

    protected final void subtractAmount(BigDecimal value){
        this.balance = this.balance.subtract(value);
    }

    protected final void depositAmount(BigDecimal value){
        this.balance = this.balance.add(value);
    }

    public abstract void deposit(BigDecimal value);

    public abstract void withdraw(BigDecimal value);

    public final void transfer(BigDecimal value, Conta recipient) {
        validateTransfer(value, recipient); // Validações comuns
        executeTransfer(value, recipient);  // Lógica de transferência
    }

    protected void validateTransfer(BigDecimal value, Conta recipient) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(recipient);

        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }

        if(value.compareTo(getBalance()) > 0) {
            throw new IllegalStateException(String.format("Saldo insuficiente. Disponível: R$ %,.2f | Tentativa: R$ %,.2f", getBalance(), value));
        }
    }

    protected void executeTransfer(BigDecimal value, Conta recipient) {
        this.subtractAmount(value);
        recipient.depositAmount(value);
    }

    @Override
    public String toString() {
        return String.format(
                """
                [Conta]
                  • Agência: %04d
                  • Número: %d
                  • Saldo: R$ %,.2f
                  %s
                """,
                agency,
                accountNumber,
                balance,
                clientInformation != null ? clientInformation.toString().replaceAll("(?m)^", "  ") : "Dados não cadastrados."
        );
    }
}

