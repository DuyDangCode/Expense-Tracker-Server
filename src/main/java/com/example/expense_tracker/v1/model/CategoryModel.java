package com.example.expense_tracker.v1.model;


import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryModel extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "Name")
    private String name;

    public CategoryModel(CreateCategoryDto categoryCreateDto, UserModel user) {
        this.user = user;
        this.name = categoryCreateDto.name();
    }

    public CategoryModel updateName(UpdateCategoryDto newCategory) {
        this.name = newCategory.name();
        return this;
    }
}
