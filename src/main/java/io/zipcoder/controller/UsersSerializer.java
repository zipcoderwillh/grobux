package io.zipcoder.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.zipcoder.domain.User;

import java.io.IOException;
import java.util.Set;

/**
 * Created by willhorton on 3/23/16.
 */
public class UsersSerializer extends JsonSerializer<Set<User>> {

    @Override
    public void serialize(Set<User> users, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartArray();
        for(User user : users) {
            jgen.writeString(user.getUserName());
        }
        jgen.writeEndArray();

    }

}
