package test.sdc.archunit.service;

import lombok.Value;

import java.time.Instant;
import java.util.Currency;

@Value
public final class Account {

    Id id;
    Balance balance;

    @Value
    public static final class Id {
        String agencyCode;
        String accountNumber;
    }

    @Value
    public static final class Balance {
        Money amount;
        Instant date;
    }

    @Value
    public static final class Money {
        long value;
        Currency currency;
    }

}