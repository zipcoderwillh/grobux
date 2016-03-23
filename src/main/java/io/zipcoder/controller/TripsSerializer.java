package io.zipcoder.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.zipcoder.domain.Trip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by willhorton on 3/23/16.
 */
public class TripsSerializer extends JsonSerializer<Set<Trip>> {

    @Override
    public void serialize(Set<Trip> trips, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartArray();
        for(Trip trip : trips) {
            jgen.writeNumber(trip.getId());
        }
        jgen.writeEndArray();

    }

}
