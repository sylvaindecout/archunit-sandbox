package test.sdc.archunit.adapter.source2;

import test.sdc.archunit.adapter.source1.AccountAdapter;
import test.sdc.archunit.service.Account;

import java.util.Collection;

import static java.util.Collections.emptyList;

public final class InternalAccountAdapter
        implements AccountAdapter {

    @Override
    public Collection<Account> getAccounts() {
        return emptyList();
    }

}
