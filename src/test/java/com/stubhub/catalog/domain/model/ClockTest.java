package com.stubhub.catalog.domain.model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class ClockTest {

    @Test
    public void givenAClock_whenNowIsCalled_thenReturnADateTimeInstanceRepresentingCurrentTime() {
        Clock clock = new Clock();

        assertThat(clock.now(), instanceOf(DateTime.class));
    }
}