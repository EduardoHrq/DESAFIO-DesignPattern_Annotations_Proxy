package org.example.fabric;

import org.example.models.BankAccount;

public interface BankFactory {

    BankAccount createNuBankAccount(String owner);

    BankAccount createInterAccount(String owner);


}
