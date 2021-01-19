package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.ValueObject;

import java.util.UUID;

public class EventId extends ValueObject<UUID> {
    private EventId(UUID id) {
        value = id;
    }

    public static EventId create(UUID id) {
        return new EventId(id);
    }
}
