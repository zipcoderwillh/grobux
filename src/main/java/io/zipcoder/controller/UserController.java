package io.zipcoder.controller;

import javax.inject.Inject;
import io.zipcoder.domain.User;
import io.zipcoder.repository.UserRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by johnb on 3/2/16.
 */
@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/users",method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        user = userRepository.save(user);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(user.getUserName())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
