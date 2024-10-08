package org.example.fabric;

import org.example.models.BankAccount;
import org.example.models.digital.BankInter;
import org.example.models.digital.Nubank;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

public class BankAccountWithPix implements BankFabric{

    @Override
    public BankAccount createNuBankAccount(String owner) {
        BankAccount bankAccount = new Nubank();
        bankAccount.setCodAccount((int) (Math.random() * (9000 - 1000 + 1)));
        bankAccount.setOwner(owner);
        bankAccount.setBalance(BigDecimal.valueOf(0));
        bankAccount.setTimeToComplete(Duration.ofSeconds(0));
        return bankAccount;
    }

    @Override
    public BankAccount createInterAccount(String owner) {
        BankAccount bankAccount = new BankInter();
        bankAccount.setCodAccount((int) (Math.random() * (9000 - 1000 + 1)));
        bankAccount.setOwner(owner);
        bankAccount.setBalance(BigDecimal.valueOf(0));
        bankAccount.setTimeToComplete(Duration.ofSeconds(0));
        return bankAccount;
    }
}
