package com.stubhub.catalog.domain.model;

public final class Date extends ValueObject<DateTime> {

    Date(DateTime date) {
        this.value = date;
    }

    public static Date create(DateTime date) {
        return new Date(date);
    }

    public boolean isBefore(Date target) {
        return this.value.isBefore(target.value);
    }

}
