package com.example.expense_tracker.v1.service;

import com.example.expense_tracker.v1.core.CategoryNotFoundException;
import com.example.expense_tracker.v1.dto.CreateCategoryDto;
import com.example.expense_tracker.v1.dto.UpdateCategoryDto;
import com.example.expense_tracker.v1.model.CategoryModel;
import com.example.expense_tracker.v1.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryModel create(CreateCategoryDto categoryInput) {
        CategoryModel newCategory = categoryRepo.save(new CategoryModel(categoryInput));
        return newCategory;
    }

    public CategoryModel getInfoById(long categoryId) {
        Optional<CategoryModel> foundCategory = categoryRepo.findById(categoryId);
        if (foundCategory.isEmpty()) {
            throw new CategoryNotFoundException();
        }
        return foundCategory.get();
    }

    public List<CategoryModel> getAll(long userId) {
        return categoryRepo.findAllByUserId(userId);
    }

    public boolean update(UpdateCategoryDto categoryUpdateDto, long categoryId) {
        CategoryModel foundCategory = getInfoById(categoryId);
        categoryRepo.save(foundCategory.updateName(categoryUpdateDto));
        return true;
    }

    public boolean delete(long categoryId) {
        CategoryModel foundCategory = getInfoById(categoryId);
        foundCategory.delete();
        return true;
    }


}
