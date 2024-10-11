package org.example.service;

import org.example.annotations.Transaction;
import org.example.exceptions.TransactionFailedException;

import java.math.BigDecimal;

public interface TransactionsService {

    boolean deposit(BigDecimal amount);

    boolean withdraw(BigDecimal amount);

    void checkAccount();

}
