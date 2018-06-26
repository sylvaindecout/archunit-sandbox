package test.sdc.archunit.adapter.source1;

import test.sdc.archunit.service.Account;
import test.sdc.archunit.service.ExternalAccountDataSource;

import java.util.Collection;

import static java.util.Arrays.asList;
import static test.sdc.archunit.adapter.source1.AccountUtils.accountInEuros;

public final class ExternalAccountAdapter
        implements ExternalAccountDataSource {

    @Override
    public Collection<Account> getAccounts() {
        return asList(
                accountInEuros("000000000123456X",12_99),
                accountInEuros("000000000987654T", -23_00)
        );
    }

}