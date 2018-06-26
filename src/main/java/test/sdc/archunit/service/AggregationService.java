package test.sdc.archunit.service;

import lombok.extern.log4j.Log4j2;
import test.sdc.common.LogDescription;

import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

@Log4j2
public class AggregationService {

    private final InternalAccountDataSource internalDataSource;
    private final ExternalAccountDataSource externalDataSource;

    public AggregationService(final InternalAccountDataSource internalDataSource,
                              final ExternalAccountDataSource externalDataSource) {
        this.internalDataSource = internalDataSource;
        this.externalDataSource = externalDataSource;
    }

    @LogDescription("Get all accounts")
    public Collection<Account> getAccounts() {
        log.info("Get list of accounts");
        return concat(
                this.internalDataSource.getAccounts().stream(),
                this.externalDataSource.getAccounts().stream()
        ).collect(toList());
    }

}