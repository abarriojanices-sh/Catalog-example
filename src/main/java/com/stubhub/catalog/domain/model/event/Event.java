package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.Date;

import java.util.Objects;

public class Event {
    private EventId eventId;
    private Date eventDate;
    private Date onSaleDate;
    private State state;

    public static Event create(EventId eventId, Date eventDate, Date onSaleDate, State state) {
        checkOnSaleDateIsBeforeEventDate(eventDate, onSaleDate);
        Event event = new Event();
        event.eventId = eventId;
        event.eventDate = eventDate;
        event.onSaleDate = onSaleDate;
        event.state = state;
        return event;
    }

    public EventId getEventId() {
        return eventId;
    }

    public void setEventId(EventId eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private static void checkOnSaleDateIsBeforeEventDate(Date eventDate, Date onSaleDate) {
        if (!onSaleDate.isBefore(eventDate)) {
            throw new EventDateMustBeAfterOnSaleDate(eventDate, onSaleDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getEventId().equals(event.getEventId()) && getEventDate().equals(event.getEventDate()) && getOnSaleDate().equals(event.getOnSaleDate()) && getState().equals(event.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventId(), getEventDate(), getOnSaleDate(), getState());
    }
}
