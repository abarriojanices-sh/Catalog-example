package com.stubhub.catalog.application.event;

import com.stubhub.catalog.domain.model.Date;
import com.stubhub.catalog.domain.model.event.EventRepository;
import com.stubhub.catalog.domain.model.event.Event;
import com.stubhub.catalog.domain.model.event.EventId;
import com.stubhub.catalog.domain.model.event.State;

public class CreateEvent {
    private EventRepository eventRepository;

    public CreateEvent(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void execute(EventId eventId, Date eventDate, Date onSaleDate) {
        State state = State.create();
        Event event = Event.create(eventId, eventDate, onSaleDate, state);
        eventRepository.save(event);
    }
}
