package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

    // Define your service methods here
	public Iterable<Category> getCategory() {
		return categoryRepository.findAll();
	}

	public Category createCategory(Category category) {
		category.setId(java.util.UUID.randomUUID().toString());
		categoryRepository.save(category);
		return category;
	}

	public Category updateCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}

}
