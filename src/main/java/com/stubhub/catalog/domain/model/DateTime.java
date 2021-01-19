package com.stubhub.catalog.domain.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import static java.time.temporal.ChronoUnit.DAYS;

import static java.time.ZoneOffset.UTC;

public final class DateTime implements Serializable {

    private static final long serialVersionUID = -4722004361461147033L;

    private Instant instant;

    public DateTime(Instant instant) {
        this.instant = instant;
    }

    public static DateTime now() {
        return new DateTime(Instant.now());
    }

    public static DateTime parse(String dateTimeString) {
        ensureDateIsNotNull(dateTimeString);

        try {
            return new DateTime(Instant.parse(dateTimeString));
        } catch (DateTimeParseException e) {
            throw new DateTimeFormatIsNotIsoStandard(dateTimeString, e);
        }
    }

    private static void ensureDateIsNotNull(String date) {
        if (date == null) {
            throw new DateTimeFormatIsNotIsoStandard(date);
        }
    }

    /**
     * Obtains an instance of {@code Instant} using milliseconds from the
     * epoch of 1970-01-01T00:00:00Z.
     *
     * @param millis the number of milliseconds from 1970-01-01T00:00:00Z
     * @return a DateTime
     */
    public static DateTime fromMillis(long millis) {
        return new DateTime(Instant.ofEpochMilli(millis));
    }

    /**
     * Converts this instant to the number of milliseconds from the epoch of 1970-01-01T00:00:00Z.
     *
     * @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z
     */
    public long toMillis() {
        return instant.toEpochMilli();
    }


    public boolean isAfter(DateTime target) {
        return instant.isAfter(target.instant);
    }

    public boolean isBefore(DateTime target) {
        return instant.isBefore(target.instant);
    }

    public DateTime plusDays(int days) {
        return new DateTime(instant.plus(days, DAYS));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() !=  DateTime.class) {
            return false;
        }
        DateTime dateTime = (DateTime) o;
        return Objects.equals(instant, dateTime.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant);
    }

    @Override
    public String toString() {
        return instant.toString();
    }

    private LocalDateTime getLocalDateTime() {
        return LocalDateTime.ofInstant(instant, UTC);
    }


}
