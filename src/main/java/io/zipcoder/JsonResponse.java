package io.zipcoder;

/**
 * Created by nicholaswebb on 3/2/16.
 */
public class JsonResponse {

    private String status = "";
    private String errorMessage = "";

    public JsonResponse(String status, String errorMessage){
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
