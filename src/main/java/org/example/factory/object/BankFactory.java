package org.example.factory.object;

import org.example.models.BankAccount;
import org.example.models.enums.ProxyType;

public interface BankFactory {

    BankAccount createNuBankAccount();

    BankAccount createInterAccount();


}
