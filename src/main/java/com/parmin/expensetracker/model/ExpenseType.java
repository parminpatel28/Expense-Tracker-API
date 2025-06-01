package com.parmin.expensetracker.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ExpenseType {
    GROCERIES,
    LEISURE,
    ELECTRONICS,
    UTILITIES,
    CLOTHING,
    HEALTH,
    OTHER
}
