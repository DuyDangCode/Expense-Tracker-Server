package com.example.expense_tracker.v1.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class ReportModel extends BaseModel {
    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long amount;

}
