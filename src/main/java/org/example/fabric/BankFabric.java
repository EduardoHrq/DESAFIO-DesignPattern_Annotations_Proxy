package org.example.fabric;

import org.example.models.BankAccount;

public interface BankFabric {

    BankAccount createNuBankAccount(String owner);

    BankAccount createInterAccount(String owner);


}
