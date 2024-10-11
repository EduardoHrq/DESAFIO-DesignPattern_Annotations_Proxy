package org.example.factory;

import org.example.models.BankAccount;
import org.example.models.withPix.BankInterWithPix;
import org.example.models.withPix.NubankWithPix;

public class BankAccountWithPix implements BankFactory {

    @Override
    public BankAccount createNuBankAccount() {
        return new NubankWithPix();
    }

    @Override
    public BankAccount createInterAccount() {
        return new BankInterWithPix();
    }
}
