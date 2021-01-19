package com.stubhub.catalog.domain.model;

public class DateTimeFormatIsNotIsoStandard extends DomainError {

    private static final long serialVersionUID = 6267071666203527203L;

    public DateTimeFormatIsNotIsoStandard(String date) {
        super(constructMessage(date));
    }

    public DateTimeFormatIsNotIsoStandard(String date, Throwable cause) {
        super(constructMessage(date), cause);
    }

    private static String constructMessage(String date) {
        return String.format("DateTime [%s] must be an ISO-8601 compliant UTC timestamp", date);
    }

    @Override
    public DomainErrorCode domainErrorCode() {
        return DomainErrorCode.INVALID;
    }
}
