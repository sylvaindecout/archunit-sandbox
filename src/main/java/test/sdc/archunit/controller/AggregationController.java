package test.sdc.archunit.controller;

import test.sdc.archunit.service.Account;
import test.sdc.archunit.service.AggregationService;

import java.util.Collection;

public class AggregationController {

    private final AggregationService service;

    public AggregationController(final AggregationService service) {
        this.service = service;
    }

    public Collection<Account> getAccounts(){
        return this.service.getAccounts();
    }

}