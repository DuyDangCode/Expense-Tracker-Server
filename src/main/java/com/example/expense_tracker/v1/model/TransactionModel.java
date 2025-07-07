package com.example.expense_tracker.v1.model;

import com.example.expense_tracker.v1.dto.TransctionType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Transactions")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private TransctionType type;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private long categoryId;

    @Column(nullable = false)
    private String text;
}
