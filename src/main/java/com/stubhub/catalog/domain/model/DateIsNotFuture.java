package com.stubhub.catalog.domain.model;

public abstract class DateIsNotFuture extends ValidationError {

    private static final long serialVersionUID = 3924368276886514417L;

    public DateIsNotFuture(DateTime date) {
        super(String.format("Date [%s] must be in the future", date));
    }
}
