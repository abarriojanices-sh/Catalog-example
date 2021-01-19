package com.stubhub.catalog.domain.model;

public class DateValidator {
    private Clock clock;

    public DateValidator(Clock clock) {
        this.clock = clock;
    }

    public void validate(DateTime dateTime, String fieldName) {
        if (dateTime.isBefore(clock.now())) {
            throw new DateIsNotFuture(dateTime) {
                @Override
                public String fieldName() {
                    return fieldName;
                }
            };
        }
    }
}
