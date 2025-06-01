package com.parmin.expensetracker.services;

import com.parmin.expensetracker.dto.SearchExpenseDto;
import com.parmin.expensetracker.model.Expense;
import com.parmin.expensetracker.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class SearchExpenseService {

    private final ExpenseRepository expenseRepository;

    public SearchExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> week() {

        return expenseRepository.pastWeek();
    }

    public List<Expense> month() {

        return expenseRepository.pastMonth();
    }

    public List<Expense> threeMonths() {

        return expenseRepository.pastThreeMonths();
    }

    public List<Expense> customSearch(SearchExpenseDto searchExpenseDto) throws ParseException {

        return expenseRepository.custom(searchExpenseDto.startDate, searchExpenseDto.EndDate );
    }
}
