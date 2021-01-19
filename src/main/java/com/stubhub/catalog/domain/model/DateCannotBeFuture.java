package com.stubhub.catalog.domain.model;

public class DateCannotBeFuture extends ValidationError {

    private static final long serialVersionUID = 3924368276886514417L;

    public DateCannotBeFuture(Date date) {
        super(String.format("Date [%s] cannot be future", date));
    }

    @Override
    public String fieldName() {
        return "Date";
    }
}
