package com.yang.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yang.loginreg.models.LoginUser;
import com.yang.loginreg.models.User;
import com.yang.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    public String index(Model model) {
    
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "form.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "form.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/welcome";
	}
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
     
		User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "form.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/welcome";
    }
	
	
	@GetMapping("/welcome")
	public String welcome(Model model , HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		if (userId != null) {
            
            User loggedUser = userService.findUser(userId);
            model.addAttribute("loggedUser", loggedUser);

            return "welcome.jsp";
        } else {
            return "redirect:/";
        }
		
	}
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
	
	
}
