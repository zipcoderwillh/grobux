package io.zipcoder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by johnb on 3/18/16.
 */
@Entity
@Table(name = "EXPENSES")
public class Expense {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EXPENSE_ID", unique = true)
    private long expenseID;
    @NotNull
    @Column(name="EXPENSE_NAME")
    private String expenseName;
    @NotNull
    @Column(name="COST")
    private BigDecimal cost;

    public BigDecimal getCost() {
        return cost;
    }

    public long getExpenseID() {
        return expenseID;
    }

    public String getExpenseName() {
        return expenseName;
    }

}
