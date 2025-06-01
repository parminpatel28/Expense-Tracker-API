package com.parmin.expensetracker.controllers;

import com.parmin.expensetracker.dto.SearchExpenseDto;
import com.parmin.expensetracker.model.Expense;
import com.parmin.expensetracker.services.SearchExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;
@Controller
@RequestMapping("expense/search")
public class SearchExpenseController {

    private final SearchExpenseService searchExpenseService;

    public SearchExpenseController(SearchExpenseService searchExpenseService) {
        this.searchExpenseService = searchExpenseService;
    }

    @RequestMapping("week")
    @GetMapping
    public ResponseEntity<List<Expense>> searchPastWeek() {
        return ResponseEntity.ok(searchExpenseService.week());
    }

    @RequestMapping("month")
    @GetMapping
    public ResponseEntity<List<Expense>> searchPastMonth() {
        return ResponseEntity.ok(searchExpenseService.month());
    }

    @RequestMapping("three-months")
    @GetMapping
    public ResponseEntity<List<Expense>> searchPast3Months() {
        return ResponseEntity.ok(searchExpenseService.threeMonths());
    }

    @RequestMapping("custom")
    @GetMapping
    public ResponseEntity<List<Expense>> customSearch(@RequestBody SearchExpenseDto searchExpenseDto) throws ParseException {
        return ResponseEntity.ok(searchExpenseService.customSearch(searchExpenseDto));
    }
}
