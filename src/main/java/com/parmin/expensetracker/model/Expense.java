package com.parmin.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @Column(name= "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private Date updatedAt;


}
