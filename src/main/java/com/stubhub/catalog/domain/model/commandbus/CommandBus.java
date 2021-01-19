package com.stubhub.catalog.domain.model.commandbus;

public interface CommandBus {
    void register(Class commandClass, CommandHandler commandHandler);
    void dispatch(Command command);
}