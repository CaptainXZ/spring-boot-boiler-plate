package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
    // Define your endpoints here

	@GetMapping("/get")
	public ResponseEntity<?> getCategory() {
		return ResponseEntity.ok(categoryService.getCategory());
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.CREATED);
	}

}
