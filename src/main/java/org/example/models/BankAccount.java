package org.example.models;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

public abstract class BankAccount {

    protected String bank;
    protected int codAccount;
    protected String owner;
    protected BigDecimal balance = BigDecimal.valueOf(0);
    protected Duration timeToComplete;

    public BankAccount() {
    }

    public BankAccount(int codAccount, String owner, BigDecimal balance, Duration timeToComplete) {
        this.codAccount = codAccount;
        this.owner = owner;
        this.balance = balance;
        this.timeToComplete = timeToComplete;
    }

    public int getCodAccount() {
        return codAccount;
    }

    public void setCodAccount(int codAccount) {
        this.codAccount = codAccount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Duration getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Duration timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
}
