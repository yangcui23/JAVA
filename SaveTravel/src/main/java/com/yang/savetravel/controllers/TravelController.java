package com.yang.savetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yang.savetravel.models.TravelModel;
import com.yang.savetravel.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	
	@GetMapping("/expenses")
    public String index(
            Model model,
            @ModelAttribute("expense") TravelModel expense) {
        List<TravelModel> expenses = travelService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
	
	@PostMapping("/expenses/submit")
    public String createOne(
            @Valid @ModelAttribute("expense") TravelModel expense,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            List<TravelModel> expenses = travelService.allExpenses();
            model.addAttribute("expenses", expenses);
            return "index.jsp";
        } else {
            travelService.createTravel(expense);
            return "redirect:/expenses";
        }
    }
	
	@GetMapping("/expenses/{id}")
    public String showOne(Model model, @PathVariable("id") Long id) {
        TravelModel expense = travelService.findTravel(id);
        model.addAttribute("expense", expense);
        return "oneExpense.jsp";
    }
	
	 @GetMapping("/expenses/edit/{id}")
	    public String update(@PathVariable("id") Long id, Model model) {
	        TravelModel expense = travelService.findTravel(id);
	        model.addAttribute("expense", expense);
	        return "editExpense.jsp";
	}
	 @PutMapping("/expenses/{id}")
	    public String update(
	            @Valid @ModelAttribute("expense") TravelModel expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editExpense.jsp";
	        } else {
	            travelService.updateTravel(expense);
	            return "redirect:/expenses";
	        }
	    }
	 @DeleteMapping("/expenses/{id}")
	    public String delete(@PathVariable("id") Long id) {
	        travelService.delete(id);
	        return "redirect:/expenses";
	 }
	
}
