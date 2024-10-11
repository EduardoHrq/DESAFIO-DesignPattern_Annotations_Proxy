package org.example;

import org.example.factory.object.BankAccountWithoutPix;
import org.example.factory.object.BankFactory;
import org.example.factory.proxy.ProxyTransactionFactory;
import org.example.factory.proxy.TransactionServiceAccountHasPix;
import org.example.factory.proxy.TransactionServiceAccountNotHasPix;
import org.example.models.BankAccount;
import org.example.models.enums.ProxyType;
import org.example.proxy.TransactionProxy;
import org.example.service.TransactionsService;
import org.example.service.TransactionsServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//
//
//        BankFactory bankFactory = new BankAccountWithoutPix();
//        BankAccount bankAccount = bankFactory.createInterAccount();
//
//        TransactionsService transactionsService = new TransactionsServiceImpl(bankAccount);
//
//        TransactionProxy transactionProxy = new TransactionProxy(transactionsService);
//
//        transactionProxy.deposit(BigDecimal.valueOf(1000));
//        transactionProxy.withdraw(BigDecimal.valueOf(1000));
//
//        transactionProxy.checkAccount();

//        TransactionsService transactionsService = (TransactionsService) Proxy.newProxyInstance(
//                TransactionsServiceImpl.class.getClassLoader(),
//                TransactionsServiceImpl.class.getInterfaces(),
//                new DynamicTransactionsProxy(new TransactionsServiceImpl(bankAccount))
//        );
//
//        transactionsService.deposit(BigDecimal.valueOf(10));
//        transactionsService.withdraw(BigDecimal.valueOf(5));
//        transactionsService.checkAccount();

        ProxyTransactionFactory proxyTransactionFactory = new TransactionServiceAccountNotHasPix();
        TransactionsService transactionsService = proxyTransactionFactory.createTransactionServiceToInterAccount(ProxyType.DEFAULT);

        transactionsService.deposit(BigDecimal.valueOf(1000));
        transactionsService.checkAccount();

    }
}