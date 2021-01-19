package com.stubhub.catalog.domain.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTimeTest {

    private static final String DATE_STRING = "2007-12-03T00:00:00Z";
    private static final String LATER_DATE_STRING = "2007-12-04T00:00:00Z";

    @Test
    void givenDateTime_whenNowIsCalled_thenADateTimeRepresentingCurrentInstantIsReturned() {
        DateTime sut = DateTime.now();

        assertThat(sut, instanceOf(DateTime.class));
    }

    @Test
    void givenStringContainingAnInstant_whenParse_thenItReturnsADateTimeRepresentingTheParsedDate() {
        DateTime sut = DateTime.parse(DATE_STRING);

        assertThat(sut, instanceOf(DateTime.class));
    }

    @Test
    void givenNullString_whenParse_thenItThrowsAnException() {
        assertThrows(DateTimeFormatIsNotIsoStandard.class, () -> DateTime.parse(null), "DateTime [null] must be an ISO-8601 compliant UTC timestamp");
    }

    @Test()
    void givenStringContainingNonISOInstant_whenParse_thenItThrowsAnException() {
        assertThrows(DateTimeFormatIsNotIsoStandard.class, () -> DateTime.parse("2007-12-03T00:00:00"), "DateTime [2007-12-03T00:00:00] must be an ISO-8601 compliant UTC timestamp");
    }

    @Test
    void givenTwoDifferentInstancesRepresentingTheSameDateTime_whenEquals_thenReturnTrue() {
        DateTime dateTime1 = DateTime.parse(DATE_STRING);
        DateTime dateTime2 = DateTime.parse(DATE_STRING);

        assertThat(dateTime1, is(dateTime2));
    }

    @Test
    void givenADateTime_whenIsAfterReceivesAPreviousDateTime_thenReturnTrue() {
        DateTime before = DateTime.parse(DATE_STRING);
        DateTime after = DateTime.parse(LATER_DATE_STRING);

        assertThat(after.isAfter(before), is(true));

    }

    @Test
    void givenADateTime_whenToString_thenTheReturnedStringContainsTheInnerDateTimeRepresentation() {
        DateTime sut = DateTime.parse(DATE_STRING);

        assertThat(sut.toString(), is(DATE_STRING));
    }

    @Test
    void givenTheNumberOfMillisecondsSinceUnixEpoch_whenFromMillisIsCalled_thenReturnTheCorrespondingDateTimeInstance() {
        long millis = Instant.parse(DATE_STRING).toEpochMilli();

        DateTime sut = DateTime.fromMillis(millis);

        assertThat(sut.toString(), is(DATE_STRING));
    }

    @Test
    void givenADateTime_whenToMillisIsCalled_thenReturnTheNumberOfMillisecondsSinceUnixEpoch() {
        long expectedMillis = Instant.parse(DATE_STRING).toEpochMilli();

        DateTime sut = DateTime.parse(DATE_STRING);

        assertThat(sut.toMillis(), is(expectedMillis));
    }
}