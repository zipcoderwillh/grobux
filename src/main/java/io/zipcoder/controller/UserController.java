package io.zipcoder.controller;

import javax.inject.Inject;
import io.zipcoder.controller.errorHandlers.CapitolOneIDErrorHandler;
import io.zipcoder.domain.CapitolCustomer;
import io.zipcoder.domain.User;
import io.zipcoder.exceptions.UserNameNotUniqueException;
import io.zipcoder.exceptions.invalidUserNameException;
import io.zipcoder.exceptions.InvalidCapitalOneUserIDException;
import io.zipcoder.repository.UserRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value="/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String username) {
        User user = userRepository.findOne(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/users",method = RequestMethod.POST)
    public ResponseEntity<?> createExistingUser(@RequestBody User user) throws InvalidCapitalOneUserIDException {
        validateUserName(user.getUserName());
        if (linkCapitolOneID(user)) {
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
        else
            throw new InvalidCapitalOneUserIDException(user.getCapitolOneID());
    }

    private void validateUserName(String username) throws UserNameNotUniqueException, invalidUserNameException {
        if (!username.matches("[A-Za-z]\\w{6,19}"))
            throw new invalidUserNameException(username);
        if (this.userRepository.findOne(username) != null)
            throw new UserNameNotUniqueException(username);
    }

    public boolean linkCapitolOneID(User user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CapitolOneIDErrorHandler());
        System.out.println("checking capitol 1");
        try {
            CapitolCustomer cap = restTemplate.getForObject("http://api.reimaginebanking.com/enterprise/customers/" + user.getCapitolOneID() + "?key=ef86aaa631f2b147ce16f6ebe1648f67", CapitolCustomer.class);
            user.setFirstName(cap.getFirst_name());
            user.setLastName(cap.getLast_name());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}