package com.stubhub.catalog.domain.model;

import static com.stubhub.catalog.domain.model.DateTime.now;
import static com.stubhub.catalog.domain.model.Date.create;

public class DateFactory {

    public static final Date currentDate() {
        return create(now());
    }

    public static final Date aDate(DateTime date) {
        return create(date);
    }
}