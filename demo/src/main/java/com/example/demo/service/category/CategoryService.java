package com.example.demo.service.category;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;

public interface CategoryService {

	Category saveCategory(Category cateGory);
	Category editCategory(Integer oldcategory, Category newCategory);
	Category getCategoryById(Integer categoryId);
	List<Category> getAllCategories();
	Category getCategoryByName(String name) throws ResourceNotFoundException;
	void deleteCategory(Integer categoryId);
}
