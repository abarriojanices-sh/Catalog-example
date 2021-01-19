package com.stubhub.catalog.application;

import com.stubhub.catalog.application.event.CreateEvent;
import com.stubhub.catalog.domain.model.Date;
import com.stubhub.catalog.domain.model.DateTime;
import com.stubhub.catalog.domain.model.event.EventRepository;
import static com.stubhub.catalog.domain.model.DateFactory.aDate;

import com.stubhub.catalog.domain.model.event.Event;
import com.stubhub.catalog.domain.model.event.EventDateMustBeAfterOnSaleDate;
import com.stubhub.catalog.domain.model.event.EventId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateEventTest {

    private static final Date EVENTDATE = aDate(DateTime.now().plusDays(10));
    private static final Date ONSALEDATE = aDate(DateTime.now().plusDays(5));
    private static final EventId EVENTID = EventId.create(UUID.randomUUID());

    private CreateEvent createEvent;
    private EventRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(EventRepository.class);
        createEvent = new CreateEvent(repository);
    }

    @Test
    void givenValidInput_whenExecute_thenEventIsPersisted() {
        createEvent.execute(EVENTID, EVENTDATE, ONSALEDATE);

        verify(repository).save(any(Event.class));
    }

    @Test
    void givenEventDateAndOnSaleDateAreTheSame_whenExecute_thenExceptionIsThrown() {
        assertThrows(EventDateMustBeAfterOnSaleDate.class, () -> createEvent.execute(EVENTID, EVENTDATE, EVENTDATE));
    }

}