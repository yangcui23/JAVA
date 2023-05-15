package com.yang.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yang.product.models.Category;
import com.yang.product.models.Product;
import com.yang.product.service.CategoryService;
import com.yang.product.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productService.allProducts();
		List<Category> categories = categoryService.allCategory();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		
		return "home.jsp";
	}

}
