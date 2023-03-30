package com.example.testhiber.service;

import com.example.testhiber.modelHiber.Category;
import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.repository.CartRepository;
import com.example.testhiber.repository.CategoryRepository;
import com.example.testhiber.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category createCategory(Category category)
    {
        return categoryRepository.save(category);
    }
}
