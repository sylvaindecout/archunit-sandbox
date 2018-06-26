package test.sdc.archunit.adapter.source2;

import test.sdc.archunit.adapter.source1.AccountAdapter;
import test.sdc.archunit.service.Account;

import java.util.Collection;

import static java.util.Collections.singletonList;
import static test.sdc.archunit.adapter.source1.AccountUtils.accountInEuros;

public final class InternalAccountAdapter
        implements AccountAdapter {

    @Override
    public Collection<Account> getAccounts() {
        return singletonList(
                accountInEuros("00001000001A",35_000_00)
        );
    }

}
