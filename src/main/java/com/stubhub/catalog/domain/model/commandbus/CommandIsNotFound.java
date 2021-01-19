package com.stubhub.catalog.domain.model.commandbus;

public class CommandIsNotFound extends RuntimeException {

    private static final long serialVersionUID = 524951054354958873L;

    public CommandIsNotFound(Command command) {
        super(String.format("CommandHandler was not found for command %s", command.getClass()));
    }

}