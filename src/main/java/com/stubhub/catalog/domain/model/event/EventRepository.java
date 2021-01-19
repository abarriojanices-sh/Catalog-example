package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.event.Event;

public interface EventRepository {
    void save(Event event);
}
