package test.sdc.archunit.service;

import lombok.extern.log4j.Log4j2;
import test.sdc.archunit.adapter.source1.ExternalAccountDataSource;
import test.sdc.archunit.adapter.source2.InternalAccountAdapter;
import test.sdc.common.LogDescription;

import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

@Log4j2
public class AggregationService {

    private final InternalAccountAdapter internalDataSource;
    private final ExternalAccountDataSource externalDataSource;

    public AggregationService(final InternalAccountAdapter internalDataSource,
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