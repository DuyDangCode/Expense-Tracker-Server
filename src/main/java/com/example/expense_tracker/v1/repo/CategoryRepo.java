package com.example.expense_tracker.v1.repo;

import com.example.expense_tracker.v1.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel, Long> {
    List<CategoryModel> findAllByUserId(long userId);

    Optional<CategoryModel> findByName(String name);
}
