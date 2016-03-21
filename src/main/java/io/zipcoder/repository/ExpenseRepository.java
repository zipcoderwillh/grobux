package io.zipcoder.repository;

import io.zipcoder.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nicholaswebb on 3/18/16.
 */
@Transactional
public interface ExpenseRepository extends CrudRepository<User, String> {
}
