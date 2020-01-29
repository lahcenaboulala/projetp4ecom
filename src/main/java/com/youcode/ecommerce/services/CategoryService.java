package com.youcode.ecommerce.services;

import java.util.List;

import com.youcode.ecommerce.entities.Category;

public interface CategoryService {

	Category findByName(String category);

	List<Category> findAll();

	Category findByCategory(Long id);

	Category save(Category category);

}
