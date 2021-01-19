package com.stubhub.catalog.domain.model.event;

import com.stubhub.catalog.domain.model.Date;
import com.stubhub.catalog.domain.model.ValidationError;

public class EventDateMustBeAfterOnSaleDate extends ValidationError {

    public EventDateMustBeAfterOnSaleDate(Date onSaleDate, Date eventDate) {
        super(String.format("EventDate [%s] must be after OnSaleDate", eventDate, onSaleDate));
    }

    @Override
    public String fieldName() {
        return "[EventDate, OnSaleDate]";
    }
}
