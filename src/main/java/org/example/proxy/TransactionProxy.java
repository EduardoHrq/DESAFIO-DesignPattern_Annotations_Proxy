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

    private Logger log = Logger.getLogger(TransactionProxy.class.getName());

    public TransactionProxy(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    public boolean deposit(BigDecimal amount) {
        Method method = null;
        try {
            method = TransactionsService.class.getMethod("deposit", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        boolean deposito = false;

        if (method.isAnnotationPresent(Transaction.class)) {
            log.info("Iniciando execução do método " + method.getName() + "." + method.getDeclaringClass().getName());

            deposito = this.transactionsService.deposit(amount);

            if (deposito) {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com sucesso");
            } else {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com erro");
            }
        }

        return deposito;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        Method method = null;
        try {
            method = TransactionsService.class.getMethod("withdraw", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        boolean saque = false;

        if (method.isAnnotationPresent(Transaction.class)) {
            log.info("Iniciando execução do método " + method.getName() + "." + method.getDeclaringClass().getName());

            saque = this.transactionsService.withdraw(amount);

            if (saque) {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com sucesso");
            } else {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com erro");
            }
        }

        return saque;
    }

    @Override
    public void checkAccount() {
        Method method = null;
        try {
            method = TransactionsService.class.getMethod("checkAccount");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        if (method.isAnnotationPresent(Transaction.class)) {
            log.info("Iniciando execução do método " + method.getName() + "." + method.getDeclaringClass().getName());

            this.transactionsService.checkAccount();

            log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com sucesso");
        }

        this.transactionsService.checkAccount();
    }
}
