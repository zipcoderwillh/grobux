package io.zipcoder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by johnb on 3/9/16.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class invalidUserNameException extends RuntimeException{

    public invalidUserNameException(String userId) {
        super("'" + userId + "' is not a valid username");
    }
}
