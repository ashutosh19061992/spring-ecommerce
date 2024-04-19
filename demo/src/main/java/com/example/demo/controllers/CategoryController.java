package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Category;
import com.example.demo.response.ResponeMessage;
import com.example.demo.response.Response;
import com.example.demo.service.category.CategoryService;
import com.example.demo.utility.RemoveExtraSpaces;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RemoveExtraSpaces removeExtraSpaces;

	@RequestMapping(method = RequestMethod.GET, value = "/save")
	public ModelAndView category() {
		ModelAndView andView = new ModelAndView("category");
		return andView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView getAllCategory() {
		ModelAndView andView = new ModelAndView("categoryList");
		List<Category> categories = this.categoryService.getAllCategories();
		andView.addObject("categories", categories);
		return andView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
	public ModelAndView updateCategory(@PathVariable("id") Integer categoryId, @ModelAttribute Category newCategory) {
		ModelAndView andView = new ModelAndView("category");
		Category category = this.categoryService.getCategoryById(categoryId);
		if (category != null) {
			this.categoryService.editCategory(categoryId, newCategory);
			andView.addObject("hasError", false);
			andView.addObject("messageType", "success");
			andView.addObject("message",
					"Category Updated and, all the product associated with this category are also updated.!!");
			return andView;
		}
		andView.addObject("hasError", true);
		andView.addObject("messageType", "danger");
		andView.addObject("message", "Category with id- " + categoryId + " does not exists !!");
		return andView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "editCategory/{id}")
	public ModelAndView getCategory(@PathVariable("id") Integer categoryId) {
		ModelAndView andView = new ModelAndView("editCategory");
		Category category = this.categoryService.getCategoryById(categoryId);
		if (category != null) {
			andView.addObject("category", category);
			return andView;
		}
		andView.addObject("hasError", true);
		andView.addObject("messageType", "danger");
		andView.addObject("message", "Category with id- " + categoryId + " does not exists !!");
		return andView;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	@ResponseBody
	public Response deleteCatergy(@PathVariable("id") Integer categoryId, Model andView) {
		Category category = this.categoryService.getCategoryById(categoryId);
		if (category != null) {
			this.categoryService.deleteCategory(categoryId);
			return new Response("200", new ResponeMessage("Deleted Successfylly", "success"));
		}
		return new Response("500", new ResponeMessage("Id not found", "danger"));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveCategory")
	public ModelAndView addCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult) {

		Category addedCategory = null;
		category = this.removeExtraSpaces.trimeSpaces(category);
		ModelAndView modelAndView = new ModelAndView("category");
		try {
			addedCategory = this.categoryService.saveCategory(category);
			if (addedCategory != null) {
				modelAndView.addObject("hasError", false);
				modelAndView.addObject("messageType", "success");
				modelAndView.addObject("message", addedCategory.getName() + " deatils added successfully. !!");
			} else {
				modelAndView.addObject("hasError", true);
				modelAndView.addObject("messageType", "danger");
				modelAndView.addObject("message", "Deatils already exists !!");
			}
		} catch (ConstraintViolationException e) {

			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			List<String> errorMessages = new ArrayList<String>(constraintViolations.size());
			errorMessages.addAll(constraintViolations.stream()
					.map(constraintViolation -> constraintViolation.getMessage()).collect(Collectors.toList()));

			modelAndView.addObject("messageType", "danger");
			modelAndView.addObject("validMessages", errorMessages);
			modelAndView.addObject("hasError", true);
		}
		modelAndView.addObject("tittle", "Add Category");
		return modelAndView;
	}
}
