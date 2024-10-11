package org.example.factory.proxy;

import org.example.models.enums.ProxyType;
import org.example.service.TransactionsService;

public interface ProxyTransactionFactory {
    TransactionsService createTransactionServiceToNubankAccount(ProxyType proxyType);
    TransactionsService createTransactionServiceToInterAccount(ProxyType proxyType);
}
