package io.zipcoder;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class YelpAPI {


    private static final String API_HOST = "api.yelp.com";
    private static final String DEFAULT_TERM = "dinner";
    private static final String DEFAULT_LOCATION = "San Francisco, CA";
    private static final int SEARCH_LIMIT = 7;
    private static final String SEARCH_PATH = "/v2/search";
    private static final String BUSINESS_PATH = "/v2/business";

    private static final String filePath = "src/main/resources/yelpKeys.txt";
    private String consumerKey, consumerSecret, token, tokenSecret;

    OAuthService service;
    Token accessToken;

    public YelpAPI() {
        try {
            readKeys();
        }
        catch (IOException e) {
            System.out.println("Yelp Credentials not loaded");
        }
        this.service =
                new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey)
                        .apiSecret(consumerSecret).build();
        this.accessToken = new Token(token, tokenSecret);
    }
    public String searchForBusinessesByLocation(String term, String location) {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
        return sendRequestAndGetResponse(request);
    }
    private OAuthRequest createOAuthRequest(String path) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://" + API_HOST + path);
        return request;
    }
    private String sendRequestAndGetResponse(OAuthRequest request) {
        System.out.println("Querying " + request.getCompleteUrl() + " ...");
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }

    private void readKeys() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {
            consumerKey = br.readLine();
            consumerSecret = br.readLine();
            token = br.readLine();
            tokenSecret = br.readLine();
        }
    }
}

