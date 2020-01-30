package com.youcode.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.services.CategoryService;

@RestController
@CrossOrigin
public class CategoryController extends ApiController {

	@Autowired
	CategoryService catService;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return catService.findAll();
	}

	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		return catService.findByCategory(id);
	}

	@PostMapping("/categories")
	public Category createCategory(@RequestBody Category category) {
		return catService.save(category);
	}

//	@PostMapping("/categories/{id}")
//	public Category updateCategory(@PathVariable long id, @Valid @RequestBody Category categoryReq) {
//		
//	}

}
