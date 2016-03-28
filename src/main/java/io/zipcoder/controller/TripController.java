package io.zipcoder.controller;

import io.zipcoder.domain.Trip;
import io.zipcoder.repository.TripRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

@RestController
public class TripController {

    @Inject
    private TripRepository tripRepository;

    @RequestMapping(value="/trips", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Trip>> getAllTrips() {
        Iterable<Trip> allTrips = tripRepository.findAll();
        return new ResponseEntity<>(allTrips, HttpStatus.OK);
    }

    @RequestMapping(value="/trips/{tripId}", method=RequestMethod.GET)
    public ResponseEntity<?> getSingleTrip(@PathVariable Long tripId) {
        Trip retrieved = tripRepository.findOne(tripId);
        return new ResponseEntity<>(retrieved, HttpStatus.OK);
    }

    @RequestMapping(value="/trips", method=RequestMethod.POST)
    public ResponseEntity<?> createTrip(@RequestBody Trip trip) {

        Trip added = tripRepository.save(trip);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTripUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(added.getId())
                .toUri();
        responseHeaders.setLocation(newTripUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

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