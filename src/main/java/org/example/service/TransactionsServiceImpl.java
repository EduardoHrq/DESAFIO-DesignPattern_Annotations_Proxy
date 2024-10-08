package org.example.service;

import org.example.annotations.Transaction;
import org.example.models.BankAccount;

import java.math.BigDecimal;

public class TransactionsServiceImpl implements TransactionsService{

    private final BankAccount bankAccount;

    public TransactionsServiceImpl(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
//    @Transaction
    public boolean deposit(BigDecimal amount) {

        if (amount.compareTo(this.bankAccount.getBalance()) >= 0) {
            try {
                Thread.sleep(this.bankAccount.getTimeToComplete());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.bankAccount.setBalance(this.bankAccount.getBalance().add(amount));
            System.out.println("Deposito de = R$ " + amount.setScale(2).toString().replace(".", ","));

            return true;
        }

        return false;
    }

    @Override
//    @Transaction
    public boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(this.bankAccount.getBalance()) <= 0) {
            try {
                Thread.sleep(this.bankAccount.getTimeToComplete());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.bankAccount.setBalance(this.bankAccount.getBalance().subtract(amount));
            System.out.println("Saque de = R$ " + amount.setScale(2).toString().replace(".", ","));

            return true;
        }

        return false;
    }

    @Override
    public void checkAccount() {

        System.out.println("\n-------------EXTRATO--------------\n\n" +
                "cod: \t\t" + this.bankAccount.getCodAccount() + "\n" +
                "name: \t\t" + this.bankAccount.getOwner() + "\n" +
                "balance: \tR$ " + this.bankAccount.getBalance().toString().replace(".", ",") + "\n" +
                "\n-------------------------------------");

    }
}
