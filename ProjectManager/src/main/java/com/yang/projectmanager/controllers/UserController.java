package com.yang.projectmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yang.projectmanager.models.LoginUser;
import com.yang.projectmanager.models.Project;
import com.yang.projectmanager.models.User;
import com.yang.projectmanager.service.ProjectService;
import com.yang.projectmanager.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "user/home.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "user/home.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "user/home.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String welcome(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user_id");

		User loggedUser = userService.findById(userId);
		List<Project> projects = projectService.allProjects();
		model.addAttribute("loggedUser", loggedUser);
		model.addAttribute("projects", projects);

		return "user/dashboard.jsp";

	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
