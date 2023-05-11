package com.yang.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yang.bookclub.models.Books;
import com.yang.bookclub.models.LoginUser;
import com.yang.bookclub.models.User;
import com.yang.bookclub.services.BookService;
import com.yang.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired 
	private BookService bookService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
		return "log.jsp";
	}
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "log.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
	}
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
     
		User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "log.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
	@GetMapping("/books")
	public String welcome(Model model , HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		if (userId != null) {
            
            User loggedUser = userService.findUser(userId);
            model.addAttribute("loggedUser", loggedUser);
            List<Books> books = bookService.allBooks();
            model.addAttribute("books", books );
            return "dashboard.jsp";
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
