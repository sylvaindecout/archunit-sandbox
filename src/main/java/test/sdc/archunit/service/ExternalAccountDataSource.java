package test.sdc.archunit.service;

import test.sdc.archunit.service.Account;

import java.util.Collection;

public interface ExternalAccountDataSource {

    Collection<Account> getAccounts();

}