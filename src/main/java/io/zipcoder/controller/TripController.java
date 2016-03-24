package io.zipcoder.controller;

import javax.inject.Inject;
import javax.xml.ws.Response;

import io.zipcoder.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.zipcoder.repository.TripRepository;
import io.zipcoder.domain.Trip;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TripController {

    @Inject
    private TripRepository tripRepository;

    @RequestMapping(value="/trips", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Trip>> getAllTrips() {
        Iterable<Trip> allTrips = tripRepository.findAll();
        return new ResponseEntity<>(tripRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/trips", method=RequestMethod.POST)
    public ResponseEntity<?> createTrip(@RequestBody Trip trip) {

        trip = tripRepository.save(trip);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTripUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trip.getId())
                .toUri();
        responseHeaders.setLocation(newTripUri);

        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }

    @RequestMapping(value="/trips/{tripId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateTrip(@RequestBody Trip trip, @PathVariable Long tripId) {
        Trip t = tripRepository.save(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="trips/{tripId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTrip(@PathVariable Long tripId) {
        tripRepository.delete(tripId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}