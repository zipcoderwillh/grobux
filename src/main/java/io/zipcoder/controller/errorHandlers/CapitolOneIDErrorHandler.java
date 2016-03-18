package io.zipcoder.controller.errorHandlers;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Created by johnb on 3/9/16.
 */

public class CapitolOneIDErrorHandler implements ResponseErrorHandler {

    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getRawStatusCode() != 200)
            return true;
        return false;
    }

    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        throw new IOException("Invalid CapitalOneID");
    }
}
