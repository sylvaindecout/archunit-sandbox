package test.sdc.archunit.service;

import lombok.extern.log4j.Log4j2;
import test.sdc.archunit.adapter.source1.AccountAdapter;
import test.sdc.common.LogDescription;

import java.util.Collection;

@Log4j2
public class AggregationService {

    private final AccountAdapter externalDataSource;

    public AggregationService(final AccountAdapter externalDataSource) {
        this.externalDataSource = externalDataSource;
    }

    @LogDescription("Get all accounts")
    public Collection<Account> getAccounts() {
        log.info("Get list of accounts");
        return this.externalDataSource.getAccounts();
    }

}