package com.example.expense_tracker.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class ReportModel extends BaseModel {
    @Id
    private long id;
    private long amount;

}
