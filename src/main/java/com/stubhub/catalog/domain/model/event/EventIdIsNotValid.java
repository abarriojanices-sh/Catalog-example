package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.ValidationError;

public class EventIdIsNotValid extends ValidationError {
    public EventIdIsNotValid(String eventId) {
        super(String.format("EventId [%s] must be an UUID(universally unique identifier)", eventId));
    }

    @Override
    public String fieldName() {
        return "eventId";
    }
}
