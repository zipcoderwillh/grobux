package io.zipcoder.controller;

import io.zipcoder.domain.Sightseeing;
import io.zipcoder.repository.ExpenseRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by nicholaswebb on 3/18/16.
 */
@RestController
public class ExpenseController {

    @Inject
    private ExpenseRepository expenseRepository;

    @RequestMapping(value="/sightseeing", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Sightseeing>> getAllSightseeing(){
      return new ResponseEntity<>((MultiValueMap<String, String>) expenseRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/sightseeing", method = RequestMethod.POST)
    public ResponseEntity<?> createSightseeing(@RequestBody Sightseeing sightseeing){

        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
