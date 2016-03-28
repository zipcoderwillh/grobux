package io.zipcoder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by johnb on 3/21/16.
 */
@RestController
public class HotelController {

    @RequestMapping(value = "/hotels",method = RequestMethod.GET)
    public ResponseEntity<String> requestHotels() {
        return new ResponseEntity<>("List of Hotels", HttpStatus.OK);
    }
}
