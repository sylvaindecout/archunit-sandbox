package test.sdc.archunit.adapter.source1;

import test.sdc.archunit.service.Account;

import java.util.Collection;

public interface ExternalAccountDataSource {

    Collection<Account> getAccounts();

}