package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.dto.CategoryCreateDto;
import com.example.expense_tracker.v1.dto.CategoryUpdateDto;
import com.example.expense_tracker.v1.model.CategoryModel;
import com.example.expense_tracker.v1.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryModel create(CategoryCreateDto categoryInput) {
        CategoryModel newCategory = categoryRepo.save(new CategoryModel(categoryInput));
        return newCategory;
    }

    public CategoryModel getInfoById(long id) throws Exception {
        Optional<CategoryModel> foundCategory = categoryRepo.findById(id);
        if (foundCategory.isEmpty())
            throw new Exception();
        return foundCategory.get();
    }

    public boolean update(CategoryUpdateDto categoryUpdateDto, long id) {

        return true;
    }

    public boolean delete() {
        return true;
    }


}
