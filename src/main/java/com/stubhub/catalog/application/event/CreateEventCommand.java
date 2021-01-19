package com.stubhub.catalog.application.event;

import com.stubhub.catalog.domain.model.commandbus.Command;

import java.util.Objects;

public class CreateEventCommand implements Command {
    public final String eventId;
    public final String eventDate;
    public final String onSaleDate;

    public CreateEventCommand(String eventId, String eventDate, String onSaleDate) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.onSaleDate = onSaleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateEventCommand)) return false;
        CreateEventCommand that = (CreateEventCommand) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(eventDate, that.eventDate) && Objects.equals(onSaleDate, that.onSaleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventDate, onSaleDate);
    }
}
