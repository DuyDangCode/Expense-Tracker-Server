package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import com.example.expense_tracker.v1.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    CategoryModel create(CreateCategoryDto categoryInput);

    CategoryModel getInfoById(long categoryId);

    List<CategoryModel> getAll(long userId);

    boolean update(UpdateCategoryDto categoryUpdateDto, long categoryId);

    boolean delete(long categoryId);
}