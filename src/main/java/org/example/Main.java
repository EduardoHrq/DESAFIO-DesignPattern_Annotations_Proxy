package org.example;

import org.example.fabric.BankAccountWithoutPix;
import org.example.fabric.BankFactory;
import org.example.models.BankAccount;
import org.example.proxy.DynamicTransactionsProxy;
import org.example.service.TransactionsService;
import org.example.service.TransactionsServiceImpl;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {


        BankFactory bankFactory = new BankAccountWithoutPix();
        BankAccount bankAccount = bankFactory.createInterAccount("eduardo");

//        TransactionsService transactionsService = new TransactionsServiceImpl(bankAccount);
//
//        TransactionProxy transactionProxy = new TransactionProxy(transactionsService);
//
//        transactionProxy.deposit(BigDecimal.valueOf(1000));
//        transactionProxy.withdraw(BigDecimal.valueOf(1000));
//
//        transactionProxy.checkAccount();

        TransactionsService transactionsService = (TransactionsService) Proxy.newProxyInstance(
                TransactionsService.class.getClassLoader(),
                TransactionsServiceImpl.class.getInterfaces(),
                new DynamicTransactionsProxy(new TransactionsServiceImpl(bankAccount))
        );

        transactionsService.deposit(BigDecimal.valueOf(10000));
        transactionsService.withdraw(BigDecimal.valueOf(1000000));
        transactionsService.checkAccount();

    }
}