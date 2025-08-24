package com.example.expense_tracker.v1.model;

import com.example.expense_tracker.v1.dto.CreateTransactionDto;
import com.example.expense_tracker.v1.dto.TransctionType;
import com.example.expense_tracker.v1.dto.UpdateTransctionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Transactions")
@NoArgsConstructor
@Getter
public class TransactionModel extends BaseModel {
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
    private long userId;

    @Column(nullable = false)
    private String note;

    public TransactionModel(CreateTransactionDto newTransactionInfo) {
        this.amount = newTransactionInfo.getAmount();
        this.type = newTransactionInfo.getType();
        this.categoryId = newTransactionInfo.getCategoryId();
        this.note = newTransactionInfo.getNote();
        this.date = newTransactionInfo.getDate();
        this.userId = newTransactionInfo.getUserId();
    }

    public void update(UpdateTransctionDto newTransctionInfo) {
        if (newTransctionInfo.getAmount() != null) {
            this.amount = newTransctionInfo.getAmount();
        }
        if (newTransctionInfo.getType() != null) {
            this.type = newTransctionInfo.getType();
        }
        if (newTransctionInfo.getCategoryId() != null) {
            this.categoryId = newTransctionInfo.getCategoryId();
        }
        if (newTransctionInfo.getNote() != null) {
            this.note = newTransctionInfo.getNote();
        }
        if (newTransctionInfo.getDate() != null) {
            this.date = newTransctionInfo.getDate();
        }
    }
}
