package io.zipcoder.repository;

import org.springframework.data.repository.CrudRepository;
import io.zipcoder.domain.Trip;


/**
 * Created by willhorton on 3/2/16.
 */
public interface TripRepository extends CrudRepository<Trip, Long> {

}
