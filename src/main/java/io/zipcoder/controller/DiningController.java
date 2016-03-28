package io.zipcoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.YelpAPI;
import io.zipcoder.domain.YelpReturn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by johnb on 3/21/16.
 */
@RestController
public class DiningController {

    @RequestMapping(value = "/dining",method = RequestMethod.GET)
    public ResponseEntity<String> requestFlights() {
        return new ResponseEntity<>("List of Restaurants", HttpStatus.OK);
    }

    @RequestMapping(value="dining/yelp", method = RequestMethod.GET)
    public ResponseEntity<YelpReturn> requestYelpDining() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        YelpAPI yelpAPI = new YelpAPI();
        YelpReturn yelpReturn = objectMapper.readValue(yelpAPI.searchForBusinessesByLocation("dinner", "San Francisco, CA"), YelpReturn.class);

        return new ResponseEntity<>(yelpReturn, HttpStatus.OK);


    }
}
