package org.example.factory.object;

import org.example.models.BankAccount;
import org.example.models.withoutPix.BankInterWithoutPix;
import org.example.models.withoutPix.NubankWithoutPix;

public class BankAccountWithoutPix implements BankFactory {
    @Override
    public BankAccount createNuBankAccount() {
        return new NubankWithoutPix();
    }

    @Override
    public BankAccount createInterAccount() {
        return new BankInterWithoutPix();
    }
}
