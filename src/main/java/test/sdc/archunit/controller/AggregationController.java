package test.sdc.archunit.controller;

import test.sdc.archunit.service.Account;
import test.sdc.archunit.service.AggregationService;
import test.sdc.common.LogDescription;

import java.util.Collection;

public class AggregationController {

    private final AggregationService service;

    public AggregationController(final AggregationService service) {
        this.service = service;
    }

    @LogDescription("Get all accounts")
    public Collection<Account> getAccounts(){
        return this.service.getAccounts();
    }

}