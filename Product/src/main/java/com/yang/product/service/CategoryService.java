package com.yang.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yang.product.models.Category;
import com.yang.product.models.Product;
import com.yang.product.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public List<Category> getAssignedCategories(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	public List<Category> getUnassignedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public List<Category> allCategory() {
        return categoryRepository.findAll();
    }
	
	
	public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }
	
	public Category findCate(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.isPresent() ? optionalCategory.get() : null;
    }
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
}
