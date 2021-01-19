package com.stubhub.catalog.domain.model;


public class DateTimeIsNotValid extends DomainError {

    public DateTimeIsNotValid(String message) {
        super(message);
    }

    @Override
    public DomainErrorCode domainErrorCode() {
        return DomainErrorCode.INVALID;
    }
}
