package com.stubhub.catalog.domain.model.commandbus;

public interface CommandHandler<T> {
    void handle(T command);
}