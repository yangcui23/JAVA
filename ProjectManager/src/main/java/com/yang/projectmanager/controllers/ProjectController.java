package com.yang.projectmanager.controllers;

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

import com.yang.projectmanager.models.Project;
import com.yang.projectmanager.models.Task;
import com.yang.projectmanager.models.User;
import com.yang.projectmanager.service.ProjectService;
import com.yang.projectmanager.service.TaskService;
import com.yang.projectmanager.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/project/new")
	public String newProject(HttpSession session,Model model,
			@ModelAttribute("project") Project project) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
          return "project/createProject.jsp";
		
		
		
	}
	@PostMapping("/project/create")
	public String createProject(@Valid @ModelAttribute("project") Project project,BindingResult result,HttpSession session,Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		if(result.hasErrors()) {


			return "project/createProject.jsp";
		}else {
			User user = userService.findById(userId);
			userService.updateUser(user);
			project.setLead(user);
			model.addAttribute("user", user);
			projectService.addProject(project);
			
			return "redirect:/dashboard";
		}
		
	}
	@GetMapping("/projects/{id}")
    public String viewProject(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            User loggedUser = userService.findById(userId);
            model.addAttribute("loggedUser", loggedUser);
            Project project = projectService.findById(id);
            model.addAttribute("project", project);
            return "project/oneProject.jsp";
        } else {
            return "redirect:/";
        }
    }
	@GetMapping("/projects/edit/{id}")
    public String editProject(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {
        // route guard
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            Project project = projectService.findById(id);
            model.addAttribute("project", project);
            model.addAttribute("users", userService.allUsers());
            return "project/editProject.jsp";
        } else {
            return "redirect:/";
        }
    }

    // submit update
    @PutMapping("/projects/edit/{id}")
    public String updateProject(
            @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            // keeps title from disappearing when you submit an empty input field
            // Project project1 = projectService.findProject(project.getId());
            // project.setTitle(project1.getTitle());
            List<User> users = userService.allUsers();
            model.addAttribute("users", users);
            return "project/editProject.jsp";
        } else {
            projectService.updateProject(project);
            return "redirect:/projects/{id}";
        }
    }

    // -------------------- Join Team ------------------ //
    @PutMapping("/projects/join/{id}")
    public String joinProject(
            @PathVariable("id") Long id,
            HttpSession session) {
        // grab current logged in user from DB using id session
        Long userId = (Long) session.getAttribute("user_id");
        User users = userService.findById(userId);
        // find the project to add to and add new member
        Project project = projectService.findById(id);
        project.getUsers().add(users);
        // save
        projectService.updateProject(project);
        return "redirect:/dashboard";
    }

    // ------------------- Leave Team ------------------ //
    @PutMapping("/projects/leave/{id}")
    public String leaveProject(
            @PathVariable("id") Long id,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User users = userService.findById(userId);
        Project project = projectService.findById(id);
        project.getUsers().remove(users);
        projectService.updateProject(project);
        return "redirect:/dashboard";
    }



    // ------------------- Delete One ------------------ //
    @DeleteMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
    	Project project = projectService.findById(id);
        projectService.deleteProject(project);
        return "redirect:/dashboard";
    }

    @GetMapping("/projects/{id}/tasks")
    public String createTask(
            @PathVariable("id") Long id, // grab the project id
            @ModelAttribute("task") Task task,
            Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User members = userService.findById(userId);
        if (session.getAttribute("user_id") != null) {
            Project project = projectService.findById(id);
            model.addAttribute("members", members);
            model.addAttribute("project", project);
            return "/task/task.jsp";
        } else {
            return "redirect:/";
        }
    }

    // submit new task
    @PostMapping("/projects/{projectId}/tasks")
    public String submitTask(
            @Valid @ModelAttribute("task") Task task,
            BindingResult result,
            @PathVariable("projectId") Long projectId,
            Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User members = userService.findById(userId);
        Project project = projectService.findById(projectId);
        if (result.hasErrors()) {
            model.addAttribute("members", members);
            System.out.println(userId);
            model.addAttribute("project", project);
            return "task/task.jsp";
        } else {
            taskService.createTask(task);
            return "redirect:/projects/{projectId}/tasks";
        }
    }
	
}
