package com.youcode.ecommerce.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.CategoryRepo;
import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

	private final CategoryRepo catRepo;

	@Autowired
	public CategoryServiceImp(CategoryRepo catRepo) {
		this.catRepo = catRepo;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = (List<Category>) catRepo.findAll();
		return categories;
	}

	@Override
	public Category findByCategory(Long id) {
		Optional<Category> optional = catRepo.findById(id);
		return optional.isPresent() ? (Category) optional.get() : null;
	}

	@Override
	public Category save(Category category) {
		return catRepo.save(category);
	}

	@Override
	public Category findByName(String category) {
		return catRepo.findByLabel(category);
	}

}
