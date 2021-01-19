package com.stubhub.catalog.domain.model;

public abstract class DomainError extends RuntimeException {

    private static final long serialVersionUID = 6322903102645698369L;

    protected DomainError(String message) {
        super(message);
    }

    protected DomainError(String message, Throwable cause) {
        super(message, cause);
    }

    public String errorCode() {
        return domainErrorCode().toString();
    }

    public abstract DomainErrorCode domainErrorCode();
}
