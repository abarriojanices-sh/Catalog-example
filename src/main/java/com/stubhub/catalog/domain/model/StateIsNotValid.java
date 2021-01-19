package com.stubhub.catalog.domain.model;

public class StateIsNotValid extends DomainError {

    public StateIsNotValid(String message) {
        super(message);
    }

    @Override
    public DomainErrorCode domainErrorCode() {
        return DomainErrorCode.INVALID;
    }
}
