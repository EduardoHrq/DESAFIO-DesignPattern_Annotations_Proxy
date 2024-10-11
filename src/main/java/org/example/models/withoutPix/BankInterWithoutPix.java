package org.example.models.withoutPix;

import org.example.models.BankAccount;

import java.time.Duration;

public class BankInterWithoutPix extends BankAccount {

    public BankInterWithoutPix() {
        this.timeToComplete = Duration.ofSeconds(3);
    }

}
