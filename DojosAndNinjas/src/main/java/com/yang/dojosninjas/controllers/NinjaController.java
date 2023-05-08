package com.yang.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.yang.dojosninjas.models.Dojo;
import com.yang.dojosninjas.models.Ninja;
import com.yang.dojosninjas.services.DojoService;
import com.yang.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/ninjas")
    public String index(
            @ModelAttribute("ninja") Ninja ninja,
            Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "NinjaForm.jsp";
    }
	
	@PostMapping("/ninjas/create")
    public String createNinja(
            @Valid @ModelAttribute("ninja") Ninja ninja,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
        	System.out.println("Successful");
            List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "NinjaForm.jsp";
        } else {
            ninjaService.createNinja(ninja);
            
            return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
        }
    }
}
