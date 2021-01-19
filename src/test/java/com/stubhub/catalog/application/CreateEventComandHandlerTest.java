package com.stubhub.catalog.application;

import com.stubhub.catalog.application.event.CreateEvent;
import com.stubhub.catalog.application.event.CreateEventCommand;
import com.stubhub.catalog.application.event.CreateEventCommandHandler;
import com.stubhub.catalog.domain.model.*;
import com.stubhub.catalog.domain.model.event.EventIdIsNotValid;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CreateEventComandHandlerTest {
    CreateEvent createEvent;
    CreateEventCommandHandler createEventCommandHandler;
    DateValidator dateValidator;

    private static final String A_EVENTDATE = DateTime.now().plusDays(10).toString();
    private static final String A_ONSALEDATE = DateTime.now().plusDays(5).toString();
    private static final String A_UUID = UUID.randomUUID().toString();

    @BeforeEach
    public void setUp() {
        createEvent = mock(CreateEvent.class);
        dateValidator = new DateValidator(new Clock());
        createEventCommandHandler = new CreateEventCommandHandler(createEvent, dateValidator);
    }

    @Test
    public void givenACommandWithInvalidUUID_whenCreateEventIsExecuted_EventIdIsNotValidIsThrown() {
        final String notValidUUID = "notValidUUID";
        CreateEventCommand command = new CreateEventCommand(notValidUUID, A_EVENTDATE, A_ONSALEDATE);
        ValidationError error = assertThrows(EventIdIsNotValid.class, () -> createEventCommandHandler.handle(command));
        assertThat(error.getMessage(),  is(equalTo("EventId [notValidUUID] must be an UUID(universally unique identifier)")));
    }

    @Test
    public void givenACommandWithNowEventDate_whenCreateEventIsExecuted_DateIsNotFutureIsThrown() {
        final String nowDate = DateTime.now().toString();
        final String expectedMessage = String.format("Date [%s] must be in the future", nowDate);
        CreateEventCommand command = new CreateEventCommand(A_UUID, nowDate, A_ONSALEDATE);
        ValidationError error = assertThrows(DateIsNotFuture.class, () -> createEventCommandHandler.handle(command));
        assertThat(error.getMessage(),  is(equalTo(expectedMessage)));
        assertThat(error.fieldName(), is(equalTo("EventDate")));
    }

    @Test
    public void givenACommandWithPassedEventDate_whenCreateEventIsExecuted_DateIsNotFutureIsThrown() {
        final String passedDate = DateTime.now().minusDays(5).toString();
        final String expectedMessage = String.format("Date [%s] must be in the future", passedDate);
        CreateEventCommand command = new CreateEventCommand(A_UUID, passedDate, A_ONSALEDATE);
        ValidationError error = assertThrows(DateIsNotFuture.class, () -> createEventCommandHandler.handle(command));
        assertThat(error.getMessage(), is(equalTo(expectedMessage)));
        assertThat(error.fieldName(), is(equalTo("EventDate")));
    }

    @Test
    public void givenACommandWithNowOnSaleDate_whenCreateEventIsExecuted_DateIsNotFutureIsThrown() {
        final String nowDate = DateTime.now().toString();
        final String expectedMessage = String.format("Date [%s] must be in the future", nowDate);
        CreateEventCommand command = new CreateEventCommand(A_UUID, A_EVENTDATE, nowDate);
        ValidationError error = assertThrows(DateIsNotFuture.class, () -> createEventCommandHandler.handle(command));
        assertThat(error.getMessage(),  is(equalTo(expectedMessage)));
        assertThat(error.fieldName(), is(equalTo("OnSaleDate")));
    }

    @Test
    public void givenACommandWithPassedOnSaleDate_whenCreateEventIsExecuted_DateIsNotFutureIsThrown() {
        final String passedDate = DateTime.now().minusDays(5).toString();
        final String expectedMessage = String.format("Date [%s] must be in the future", passedDate);
        CreateEventCommand command = new CreateEventCommand(A_UUID, A_EVENTDATE, passedDate);
        ValidationError error = assertThrows(DateIsNotFuture.class, () -> createEventCommandHandler.handle(command));
        assertThat(error.getMessage(), is(equalTo(expectedMessage)));
        assertThat(error.fieldName(), is(equalTo("OnSaleDate")));
    }
}
