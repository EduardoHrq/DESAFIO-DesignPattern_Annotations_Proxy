package org.example.models.withoutPix;

import org.example.models.BankAccount;

import java.time.Duration;

public class NubankWithoutPix extends BankAccount {

    public NubankWithoutPix() {
        this.timeToComplete = Duration.ofSeconds(3);
    }
}
