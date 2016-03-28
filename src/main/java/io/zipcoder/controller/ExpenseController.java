package io.zipcoder.controller;

import io.zipcoder.repository.ExpenseRepository;
import io.zipcoder.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.zipcoder.domain.Expense;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

/**
 * Created by johnb on 3/18/16.
 */


@RestController
public class ExpenseController {

    @Inject
    private UserRepository userRepository;
    @Inject
    private ExpenseRepository expenseRepository;

    @RequestMapping(value="/users/{userName}/expenses",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Expense>> getAllExpenses() {
        return new ResponseEntity<>(expenseRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/users/{userName}/expenses",method = RequestMethod.POST)
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {
        expense = expenseRepository.save(expense);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newExpenseURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/users/{username}/expenses/{expenseID}")
                .buildAndExpand(expense.getExpenseID())
                .toUri();
        responseHeaders.setLocation(newExpenseURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/users/{userName}/expenses/{expenseID}",method = RequestMethod.GET)
    public ResponseEntity<?> getExpense(@RequestBody Expense expense, @PathVariable Long expenseID){
        Expense e = expenseRepository.findOne(expenseID);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @RequestMapping(value="/users/{userName}/expenses/{expenseID}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateExpense(@RequestBody Expense expense, @PathVariable Long expenseID) {
        Expense e = expenseRepository.save(expense);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/users/{userName}/expenses/{expenseID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExpense(@PathVariable Long expenseID) {
        expenseRepository.delete(expenseID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
