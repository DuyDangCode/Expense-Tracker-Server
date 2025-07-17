package com.example.expense_tracker.v1.service;

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

    public CategoryModel getInfoById(long categoryId) throws Exception {
        Optional<CategoryModel> foundCategory = categoryRepo.findById(categoryId);
        if (foundCategory.isEmpty())
            throw new Exception();
        return foundCategory.get();
    }

    public List<CategoryModel> getAll(long userId) {
        return categoryRepo.findAllByUserId(userId);
    }

    public boolean update(UpdateCategoryDto categoryUpdateDto, long categoryId) {
        CategoryModel foundCategory = checkAndGetCategoryExists(categoryId);
        categoryRepo.save(foundCategory.updateName(categoryUpdateDto));
        return true;
    }

    private CategoryModel checkAndGetCategoryExists(long categoryId) {
        Optional<CategoryModel> foundCategory = categoryRepo.findById(categoryId);
        if (foundCategory.isEmpty()) {
            throw new InvalidParameterException("Not found category");
        }
        return foundCategory.get();
    }

    public boolean delete(long categoryId) {
        CategoryModel foundCategory = checkAndGetCategoryExists(categoryId);
        foundCategory.delete();
        return true;
    }


}
