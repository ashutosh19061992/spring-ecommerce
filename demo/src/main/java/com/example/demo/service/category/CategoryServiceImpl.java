package com.example.demo.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.jparepository.category.CategoryRepository;
import com.example.demo.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category cateGory) {
		return this.categoryRepository.save(cateGory);
	}

	@Override
	public Category editCategory(Integer oldcategoryId, Category newCategory) {

		Category oldCategory = this.categoryRepository.findById(oldcategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Update Method :- Category ", oldcategoryId));

		oldCategory.setName(newCategory.getName());

		return this.categoryRepository.save(oldCategory);
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Get Method :- Category ", categoryId));
		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = this.categoryRepository.findAll();
		return categories;
	}

	@Override
	public Category getCategoryByName(String catName) throws ResourceNotFoundException {
		Category category = null;
		try {
			category = this.categoryRepository.findByName(catName);
		} catch (ResourceNotFoundException e) {
			e.getMessage();
		}
		return category;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Delete Method :- Category ", categoryId));
		this.categoryRepository.delete(category);
	}
}
