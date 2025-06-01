package com.parmin.expensetracker.services;

import com.parmin.expensetracker.configurations.exceptions.ResourceNotFoundException;
import com.parmin.expensetracker.dto.ExpenseDto;
import com.parmin.expensetracker.model.Expense;

import com.parmin.expensetracker.repositories.ExpenseRepository;
import com.parmin.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(ExpenseDto expense) {

        Expense newExpense = new Expense();

        newExpense.setAmount(expense.getAmount());
        newExpense.setExpenseType(expense.getExpenseType());

        return expenseRepository.save(newExpense);

    }

    @Transactional
    public Expense updateExpense(Long id, ExpenseDto expense) {

        Expense existingExpense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not Found!"));
        existingExpense.setExpenseType(expense.getExpenseType());
        existingExpense.setAmount(expense.getAmount());

        return expenseRepository.save(existingExpense);
    }

    public void deleteExpense(Long id) {

        Expense existingExpense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not Found!"));

        expenseRepository.deleteById(existingExpense.getId());

    }
}
