package com.example.expense_tracker.v1.model;


import com.example.expense_tracker.v1.dto.CategoryCreateDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryModel {

    @Id
    private long id;

    @Column(name = "UserId", nullable = false)
    private long userId;

    @Column(name = "Name")
    private String name;

    public CategoryModel(CategoryCreateDto categoryCreateDto) {
        this.userId = categoryCreateDto.getUserId();
        this.name = categoryCreateDto.getName();
    }
}
