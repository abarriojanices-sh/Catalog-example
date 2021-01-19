package com.stubhub.catalog.domain.model;

public abstract class ValidationError extends DomainError {

    private static final long serialVersionUID = -2699244081692793371L;

    protected ValidationError(String message) {
        super(message);
    }

    protected ValidationError(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public DomainErrorCode domainErrorCode() {
        return DomainErrorCode.INVALID;
    }

    public abstract String fieldName();
}
