package org.example.models;

import java.math.BigDecimal;
import java.time.Duration;

public abstract class BankAccount {

    protected String bank;
    protected int codAccount;
    protected String owner;
    protected BigDecimal balance = BigDecimal.valueOf(0);
    protected Duration timeToComplete;

    public BankAccount() {
        this.codAccount =(int) (Math.random() * (9000 - 1000 + 1));
    }

    public BankAccount(String owner, BigDecimal balance, Duration timeToComplete) {
        this.codAccount =(int) (Math.random() * (9000 - 1000 + 1));
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

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

}
