package io.zipcoder.repository;

import io.zipcoder.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nicholaswebb on 3/18/16.
 */
public interface ExpenseRepository extends CrudRepository<User, String> {
}
