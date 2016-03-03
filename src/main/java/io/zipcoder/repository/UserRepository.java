package io.zipcoder.repository;

import io.zipcoder.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by johnb on 3/2/16.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
