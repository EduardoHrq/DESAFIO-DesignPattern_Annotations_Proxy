package org.example.factory.proxy;

import org.example.models.enums.ProxyType;
import org.example.models.withPix.BankInterWithPix;
import org.example.models.withPix.NubankWithPix;
import org.example.models.withoutPix.BankInterWithoutPix;
import org.example.models.withoutPix.NubankWithoutPix;
import org.example.proxy.TransactionProxy;
import org.example.service.TransactionsService;
import org.example.service.TransactionsServiceImpl;

public class TransactionServiceAccountNotHasPix implements ProxyTransactionFactory {

    @Override
    public TransactionsService createTransactionServiceToNubankAccount(ProxyType proxyType) {
        return switch (proxyType) {
            case NONE -> (TransactionsService) ProxyType.NONE.instance(new TransactionsServiceImpl(new NubankWithoutPix()));
            case DEFAULT -> (TransactionsService)  ProxyType.DEFAULT.instance(new TransactionsServiceImpl(new NubankWithoutPix()));
            case DYNAMIC -> (TransactionsService)  ProxyType.DYNAMIC.instance(new TransactionsServiceImpl(new NubankWithoutPix()));
        };
    }

    @Override
    public TransactionsService createTransactionServiceToInterAccount(ProxyType proxyType) {
        return switch (proxyType) {
            case NONE -> (TransactionsService) ProxyType.NONE.instance(new TransactionsServiceImpl(new BankInterWithoutPix()));
            case DEFAULT -> (TransactionsService)  ProxyType.DEFAULT.instance(new TransactionsServiceImpl(new BankInterWithoutPix()));
            case DYNAMIC -> (TransactionsService)  ProxyType.DYNAMIC.instance(new TransactionsServiceImpl(new BankInterWithoutPix()));
        };
    }
}
