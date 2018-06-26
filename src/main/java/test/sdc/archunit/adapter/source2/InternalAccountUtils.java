package test.sdc.archunit.adapter.source2;

import lombok.NonNull;
import test.sdc.archunit.service.Account;

import java.util.Currency;

import static java.lang.String.format;
import static java.time.Instant.now;

final class InternalAccountUtils {

    private static final Currency EUROS = Currency.getInstance("EUR");

    private InternalAccountUtils() {}

    static Account accountInEuros(@NonNull final String accountId, final long value) {
        return new Account(accountId(accountId), balanceInEuros(value));
    }

    private static Account.Id accountId(final String accountId) {
        if (accountId.length() != 12) {
            throw new IllegalArgumentException(format("Invalid account ID: %s (expected: 12 characters)", accountId));
        }
        final String agencyCode = accountId.substring(0, 5);
        final String accountNumber = accountId.substring(6);
        return new Account.Id(agencyCode, accountNumber);
    }

    private static Account.Balance balanceInEuros(long value) {
        return new Account.Balance(new Account.Money(value, EUROS), now());
    }

}
