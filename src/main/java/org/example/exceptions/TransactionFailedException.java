package org.example.exceptions;

public class TransactionFailedException extends RuntimeException {
    public TransactionFailedException(String msg) {
        super(msg);
        System.err.println(msg);
    }
}
