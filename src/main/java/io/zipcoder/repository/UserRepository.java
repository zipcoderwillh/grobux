package io.zipcoder.repository;

import io.zipcoder.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by johnb on 3/2/16.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, String>{
}
