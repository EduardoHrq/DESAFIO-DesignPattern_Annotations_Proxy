package org.example.factory.proxy;

import org.example.models.enums.ProxyType;
import org.example.models.withPix.BankInterWithPix;
import org.example.models.withPix.NubankWithPix;
import org.example.proxy.TransactionProxy;
import org.example.service.TransactionsService;
import org.example.service.TransactionsServiceImpl;

public class TransactionServiceAccountHasPix implements ProxyTransactionFactory {

    @Override
    public TransactionsService createTransactionServiceToNubankAccount(ProxyType proxyType) {
        return switch (proxyType) {
            case NONE -> (TransactionsService) ProxyType.NONE.instance(new TransactionsServiceImpl(new NubankWithPix()));
            case DEFAULT -> (TransactionsService)  ProxyType.DEFAULT.instance(new TransactionsServiceImpl(new NubankWithPix()));
            case DYNAMIC -> (TransactionsService)  ProxyType.DYNAMIC.instance(new TransactionsServiceImpl(new NubankWithPix()));
        };
    }

    @Override
    public TransactionsService createTransactionServiceToInterAccount(ProxyType proxyType) {
        return switch (proxyType) {
            case NONE -> (TransactionsService) ProxyType.NONE.instance(new TransactionsServiceImpl(new BankInterWithPix()));
            case DEFAULT -> (TransactionsService)  ProxyType.DEFAULT.instance(new TransactionsServiceImpl(new BankInterWithPix()));
            case DYNAMIC -> (TransactionsService)  ProxyType.DYNAMIC.instance(new TransactionsServiceImpl(new BankInterWithPix()));
        };
    }
}
