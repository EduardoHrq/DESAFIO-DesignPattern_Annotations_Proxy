package org.example.proxy;

import org.example.annotations.Transaction;
import org.example.service.TransactionsService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class DynamicTransactionsProxy implements InvocationHandler {

    private final TransactionsService transactionsService;
    private Logger log = Logger.getLogger(DynamicTransactionsProxy.class.getName());

    public DynamicTransactionsProxy(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean chamada = false;
        if (method.isAnnotationPresent(Transaction.class)) {
            log.info("Iniciando execução do método " + method.getName() + "." + method.getDeclaringClass().getName());
            chamada = (boolean) method.invoke(transactionsService, args[0]);
            if (chamada) {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com sucesso");
            } else {
                log.info("Finalizando a execução do metodo " + method.getName() + "." + method.getDeclaringClass().getName() + " com erro");
            }
        } else {
            method.invoke(transactionsService);
        }


        return chamada;
    }
}
