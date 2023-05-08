package com.yang.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yang.dojosninjas.models.Dojo;
import com.yang.dojosninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/dojos")
	public String index(
		Model model,
		@ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	
	@PostMapping("/dojos/submit")
    public String createDojo(
            @Valid @ModelAttribute("dojo") Dojo dojo,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "index.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
	@GetMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "DojosAndNinjas.jsp";
    }
	
}
