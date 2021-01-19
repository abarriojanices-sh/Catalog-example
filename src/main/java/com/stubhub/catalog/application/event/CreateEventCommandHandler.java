package com.stubhub.catalog.application.event;

import com.stubhub.catalog.domain.model.Date;
import com.stubhub.catalog.domain.model.DateTime;
import com.stubhub.catalog.domain.model.DateValidator;
import com.stubhub.catalog.domain.model.commandbus.CommandHandler;
import com.stubhub.catalog.domain.model.event.EventId;
import com.stubhub.catalog.domain.model.event.EventIdIsNotValid;

import java.util.UUID;

public class CreateEventCommandHandler implements CommandHandler<CreateEventCommand> {
    private CreateEvent createEvent;
    private DateValidator dateValidator;

    public CreateEventCommandHandler(CreateEvent createEvent, DateValidator dateValidator) {
        this.createEvent = createEvent;
        this.dateValidator = dateValidator;
    }

    @Override
    public void handle(CreateEventCommand command) {
        EventId eventId = parseEventId(command.eventId);
        Date eventDate = Date.create(parseEventDate(command.eventDate));
        Date onSaleDate = Date.create(parseOnSaleDate(command.onSaleDate));
        createEvent.execute(eventId, eventDate, onSaleDate);
    }

    private DateTime parseEventDate(String date) {
        DateTime dateTime = DateTime.parse(date);
        dateValidator.validate(dateTime, "EventDate");
        return dateTime;
    }

    private DateTime parseOnSaleDate(String date) {
        DateTime dateTime = DateTime.parse(date);
        dateValidator.validate(dateTime, "OnSaleDate");
        return dateTime;
    }

    private EventId parseEventId(String eventId) {
        try {
            return EventId.create(UUID.fromString(eventId));
        } catch(IllegalArgumentException e) {
            throw new EventIdIsNotValid(eventId);
        }
    }


}
