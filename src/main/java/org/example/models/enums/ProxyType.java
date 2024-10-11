package org.example.models.enums;

import org.example.proxy.DynamicTransactionsProxy;
import org.example.proxy.TransactionProxy;
import org.example.service.TransactionsService;

import java.lang.reflect.Proxy;

public enum ProxyType {
    NONE {
        @Override
        public Object instance(Object target) {
            return (TransactionsService) target;
        }
    },
    DEFAULT {
        @Override
        public Object instance(Object target) {
            return (TransactionsService) new TransactionProxy((TransactionsService) target);
        }
    },
    DYNAMIC {
        @Override
        public Object instance(Object target) {
            return (TransactionsService) Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new DynamicTransactionsProxy(target)
            );
        }
    };

    public abstract Object instance(Object target);

}
