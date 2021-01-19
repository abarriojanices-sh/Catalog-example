package com.stubhub.catalog.domain.model;

public class DateFormatIsNotValid extends ValidationError {

    private static final long serialVersionUID = 4809054172419863720L;

    public DateFormatIsNotValid(DateTimeFormatIsNotIsoStandard dateError) {
        super(dateError.getMessage(), dateError);
    }

    @Override
    public String fieldName() {
        return "Date";
    }
}
