package io.zipcoder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by johnb on 3/4/16.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameNotUniqueException extends RuntimeException {

    public UserNameNotUniqueException(String userId) {
        super("username '" + userId + "'is unavailable.");
    }
}
