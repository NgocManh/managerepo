package com.example.testhiber.repository;

import com.example.testhiber.modelHiber.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
