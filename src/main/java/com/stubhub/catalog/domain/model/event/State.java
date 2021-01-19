package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.StateIsNotValid;
import com.stubhub.catalog.domain.model.ValueObject;

public final class State extends ValueObject<String> {
    private enum States {
        ACTIVE, CANCELLED, HIDDEN
    }

    private State(String state) {
        checkStateIsValid(state);
        super.value = state;
    }

    private static void checkStateIsValid(String state) {
        try {
            States.valueOf(state);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new StateIsNotValid(state);
        }
    }

    public static State create(String state) {
        return new State(state);
    }

    public static State create() {
        return new State(States.ACTIVE.name());
    }

}
