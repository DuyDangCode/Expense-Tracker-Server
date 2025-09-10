package com.example.expense_tracker.v1.model;


import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryModel extends BaseModel {
    @Column(name = "UserId", nullable = false)
    private long userId;

    @Column(name = "Name")
    private String name;

    public CategoryModel(CreateCategoryDto categoryCreateDto) {
        this.userId = categoryCreateDto.getUserId();
        this.name = categoryCreateDto.getName();
    }

    public CategoryModel updateName(UpdateCategoryDto newCategory) {
        this.name = newCategory.getName();
        return this;
    }
}
