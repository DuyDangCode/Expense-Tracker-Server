package com.example.expense_tracker.v1.model;


import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(name = "is_delete")
    //0 is false, 1 is true
    protected int isDelete = 0;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = new Date();
    }

    public void delete() {
        this.isDelete = 1;
    }

}
