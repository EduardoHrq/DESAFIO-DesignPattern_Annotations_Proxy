package org.example.service;

import org.example.annotations.Transaction;

import java.math.BigDecimal;

public interface TransactionsService {

    @Transaction
    boolean deposit(BigDecimal amount);

    @Transaction
    boolean withdraw(BigDecimal amount);

    void checkAccount();

}
