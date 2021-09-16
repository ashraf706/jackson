package org.example.dto;



import com.fasterxml.jackson.annotation.*;

import java.time.*;

public class Itinerary {

    private LocalDate journeyDate;

    @JsonCreator
    public Itinerary(@JsonProperty("journey_date") LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }
}
