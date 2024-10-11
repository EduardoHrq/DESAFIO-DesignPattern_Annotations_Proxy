package org.example.proxy;

import org.example.annotations.Transaction;
import org.example.models.BankAccount;
import org.example.service.TransactionsService;
import org.example.service.TransactionsServiceImpl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TransactionProxy implements TransactionsService {

    private final TransactionsService transactionsService;

    private final Logger log = Logger.getLogger(TransactionProxy.class.getName());

    public TransactionProxy(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    public boolean deposit(BigDecimal amount) {
        boolean deposito = false;

        log.info("Iniciando execucao do metodo deposit");

        deposito = transactionsService.deposit(amount);

        log.info("Finalizando com sucesso a execucao do metodo deposit");

        return deposito;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        boolean withdraw = false;

        log.info("Iniciando execucao do metodo deposit");

        withdraw = transactionsService.withdraw(amount);

        log.info("Finalizando com sucesso a execucao do metodo deposit");


        return withdraw;
    }

    @Override
    public void checkAccount() {

        this.transactionsService.checkAccount();

    }
}
