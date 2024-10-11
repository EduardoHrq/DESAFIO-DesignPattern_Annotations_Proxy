package org.example.proxy;

import org.example.annotations.Transaction;
import org.example.exceptions.TransactionFailedException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class DynamicTransactionsProxy implements InvocationHandler {

    private final Object transactionsService;
    private final Logger log = Logger.getLogger(DynamicTransactionsProxy.class.getName());

    public DynamicTransactionsProxy(Object transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (transactionsService.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Transaction.class)) {
            log.info("Iniciando executação do metodo " + method.getName());

            Object resultado = method.invoke(transactionsService, args);

            log.info("Finalizando com sucesso a execução do metodo " + method.getName());

            return resultado;
        }
        return method.invoke(transactionsService, args);
    }
}
