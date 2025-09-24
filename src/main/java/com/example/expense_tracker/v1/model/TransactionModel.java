package com.example.expense_tracker.v1.model;

import com.example.expense_tracker.v1.dto.CreateTransactionDto;
import com.example.expense_tracker.v1.dto.TransctionType;
import com.example.expense_tracker.v1.dto.UpdateTransctionDto;
import com.example.expense_tracker.v1.repo.UserRepo;
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
    @Column(name = "transaction_id")
    private long id;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private TransctionType type;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(nullable = false)
    @Lob
    private String note;

    public TransactionModel(CreateTransactionDto newTransactionInfo, UserModel user) {
        this.amount = newTransactionInfo.amount();
        this.type = newTransactionInfo.type();
        this.category = newTransactionInfo.category();
        this.note = newTransactionInfo.note();
        this.date = newTransactionInfo.date();
        this.user = user;
    }

    public void update(UpdateTransctionDto newTransctionInfo) {
        if (newTransctionInfo.amount() != null) {
            this.amount = newTransctionInfo.amount();
        }
        if (newTransctionInfo.type() != null) {
            this.type = newTransctionInfo.type();
        }
        if (newTransctionInfo.category() != null) {
            this.category = newTransctionInfo.category();
        }
        if (newTransctionInfo.note() != null) {
            this.note = newTransctionInfo.note();
        }
        if (newTransctionInfo.date() != null) {
            this.date = newTransctionInfo.date();
        }
    }
}
