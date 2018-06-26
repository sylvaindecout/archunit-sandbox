package test.sdc.archunit.adapter.source1;

import test.sdc.archunit.service.Account;

import java.util.Collection;

import static java.util.Collections.emptyList;

public class ExternalAccountAdapter
        implements AccountAdapter {

    @Override
    public Collection<Account> getAccounts(){
        return emptyList();
    }

}