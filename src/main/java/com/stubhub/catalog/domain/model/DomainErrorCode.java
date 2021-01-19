package com.stubhub.catalog.domain.model;

public enum DomainErrorCode {
    INVALID("INVALID"),
    NOT_FOUND("NOT FOUND"),
    DUPLICATED("DUPLICATED"),
    INTERNAL("INTERNAL");

    private String description;

    DomainErrorCode(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
