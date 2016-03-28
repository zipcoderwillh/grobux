package io.zipcoder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by willhorton on 3/28/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Trip not found")
public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException(Long id) {
        super("'Trip " + id + " was not found.");
    }

}
