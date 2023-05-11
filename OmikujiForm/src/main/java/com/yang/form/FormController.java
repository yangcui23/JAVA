package com.yang.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {

	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/submit")
	public String formData(HttpSession session, 
		@RequestParam(value = "number") Integer number,
		@RequestParam(value = "city") String city, 
		@RequestParam(value = "person") String person,
		@RequestParam(value = "hobby") String hobby, 
		@RequestParam(value = "living") String living,
		@RequestParam(value = "something") String something) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("something", something);
		return "redirect:/omikuji/show";
	}
	
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		 model.addAttribute("number", session.getAttribute("number"));
		 model.addAttribute("city", session.getAttribute("city"));
		 model.addAttribute("person", session.getAttribute("person"));
		 model.addAttribute("hobby", session.getAttribute("hobby"));
		 model.addAttribute("living", session.getAttribute("living"));
		 model.addAttribute("something", session.getAttribute("something"));
		return "omikuji.jsp";
	}
}
