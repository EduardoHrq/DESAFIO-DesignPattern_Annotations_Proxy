package org.example.factory;

import org.example.models.BankAccount;

public interface BankFactory {

    BankAccount createNuBankAccount();

    BankAccount createInterAccount();


}
