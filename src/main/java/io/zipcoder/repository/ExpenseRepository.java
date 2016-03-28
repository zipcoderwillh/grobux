package io.zipcoder.repository;

import com.sun.org.apache.bcel.internal.generic.D2F;
import io.zipcoder.domain.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by johnb on 3/18/16.
 */
@Transactional
public interface ExpenseRepository extends CrudRepository<Expense,Long>{
}
