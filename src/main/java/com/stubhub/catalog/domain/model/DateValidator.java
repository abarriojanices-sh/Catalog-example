package com.stubhub.catalog.domain.model;

public class DateValidator {
    private Clock clock;

    public DateValidator(Clock clock) {
        this.clock = clock;
    }

    public void validate(Date date) {
        DateTime actualDate = date.get();
        if (actualDate.isBefore(clock.now())) {
            throw new DateCannotBeFuture(date);
        }
    }
}
