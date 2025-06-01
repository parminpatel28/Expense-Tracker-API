package com.parmin.expensetracker.repositories;

import com.parmin.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Query(value = "SELECT * FROM expense WHERE created_at >= Now() - INTERVAL '7 days'", nativeQuery = true)
    List<Expense> pastWeek();

    @Query(value = "SELECT * FROM expense WHERE created_at >= Now() - INTERVAL '30 days'", nativeQuery = true)
    List<Expense> pastMonth();

    @Query(value = "SELECT * FROM expense WHERE created_at >= Now() - INTERVAL '90 days'", nativeQuery = true)
    List<Expense> pastThreeMonths();

    @Query(value = "SELECT * FROM expense WHERE created_at BETWEEN TO_TIMESTAMP(:start, 'YYYY-MM-DD HH24:MI:SS') AND TO_TIMESTAMP(:end, 'YYYY-MM-DD HH24:MI:SS')", nativeQuery = true)
    List<Expense> custom(@Param("start") String start, @Param("end") String end);

}
