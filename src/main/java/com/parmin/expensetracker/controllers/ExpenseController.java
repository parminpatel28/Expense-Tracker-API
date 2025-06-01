package com.parmin.expensetracker.controllers;

import com.parmin.expensetracker.dto.ExpenseDto;
import com.parmin.expensetracker.model.Expense;
import com.parmin.expensetracker.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("create")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDto expenseDto) {

        Expense expense = expenseService.saveExpense(expenseDto);

        return ResponseEntity.ok(expense);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto) {

        Expense expense = expenseService.updateExpense(id, expenseDto);

        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable("id") Long id) {

        expenseService.deleteExpense(id);

        return ResponseEntity.noContent().build();
    }
}
