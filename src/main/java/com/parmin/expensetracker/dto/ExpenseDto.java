package com.parmin.expensetracker.dto;

import com.parmin.expensetracker.model.ExpenseType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExpenseDto {

    private float amount;
    private ExpenseType expenseType;
}
