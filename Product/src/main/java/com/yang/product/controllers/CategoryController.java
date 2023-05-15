package com.yang.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yang.product.models.Category;
import com.yang.product.models.Product;
import com.yang.product.service.CategoryService;
import com.yang.product.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	public CategoryController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/category/new")
	public String category(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	
	@PostMapping("/category/submit")
	public String newCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("category",category);
			return "newCategory.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/";
		
	}
	
	@GetMapping("/category/{id}")
	public String addCategory(@PathVariable("id") Long id,
			Model model) {
		Category category = categoryService.findCate(id);

		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", productService.getAssignedProducts(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
		
		
		return "addProduct.jsp";
	}
	@PostMapping("/category/{id}/assign")
	public String assignCategory(@PathVariable("id") Long id,
			@RequestParam(value="productId") Long productId,
			Model model) {
		Category category = categoryService.findCate(id);
		Product product = productService.findById(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		return "redirect:/";
	}
	
	
	
}
