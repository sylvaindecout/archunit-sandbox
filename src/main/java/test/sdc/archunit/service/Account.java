package test.sdc.archunit.service;

import lombok.Value;

import java.time.Instant;
import java.util.Currency;

@Value
public final class Account {

    Id id;
    Balance balance;

    @Value
    private final class Id {
        String agencyCode;
        String accountNumber;
    }

    @Value
    private final class Balance {
        Money amount;
        Instant date;
    }

    @Value
    private final class Money {
        Long value;
        Currency currency;
    }

}