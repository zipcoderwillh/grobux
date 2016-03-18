package io.zipcoder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by nicholaswebb on 3/2/16.
 */
@RestController
public class AirfareInfoController {

    @RequestMapping(value = "/")
    public ResponseEntity<AirfareInfo> get(){
        AirfareInfo airfareInfo = new AirfareInfo();
        airfareInfo.setAdults(2);
        airfareInfo.setDepartLocation("PHL");
        airfareInfo.setDestination("SAN");
        airfareInfo.setChildren(3);
        airfareInfo.setDepartureDate("12/24/2016");
        airfareInfo.setPrice(1324.32);
        airfareInfo.setReturnDate("12/30/2016");
        return new ResponseEntity<AirfareInfo>(airfareInfo, HttpStatus.OK);
    }

}
