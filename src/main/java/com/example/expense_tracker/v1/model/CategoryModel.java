package com.example.expense_tracker.v1.model;


import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@Getter
@NoArgsConstructor
public class CategoryModel extends BaseModel {
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private UserModel user;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @JsonIgnore
    private Long id;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TransactionModel> transactionModelList;

    public CategoryModel(CreateCategoryDto categoryCreateDto, UserModel user) {
        this.user = user;
        this.name = categoryCreateDto.name();
    }

    public CategoryModel updateName(UpdateCategoryDto newCategory) {
        this.name = newCategory.name();
        return this;
    }
}
