package com.yang.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yang.product.models.Category;
import com.yang.product.models.Product;
import com.yang.product.service.CategoryService;
import com.yang.product.service.ProductService;

import jakarta.validation.Valid;



@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	@Autowired 
	private CategoryService categoryService;
	
	
	@GetMapping("/products/new")
	public String products(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/submit")
	public String newProduct(@Valid @ModelAttribute("product")Product product,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("product",product);
			return "newProduct.jsp";
		}
		productService.addProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String addCategory(@PathVariable("id") Long id,
			Model model) {
		Product product = productService.findById(id);

		model.addAttribute("product", product);
		model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));
		
		
		return "addCategory.jsp";
	}
	
	@PostMapping("/products/{id}/assign")
	public String assignCategory(@PathVariable("id") Long id,
			@RequestParam(value="categoryId") Long categoryId,
			Model model) {
		Product product = productService.findById(id);
		Category category = categoryService.findCate(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		return "redirect:/";
	}
	
	
	
}
