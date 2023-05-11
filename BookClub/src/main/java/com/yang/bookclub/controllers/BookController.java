package com.yang.bookclub.controllers;

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

import com.yang.bookclub.models.Books;
import com.yang.bookclub.models.User;
import com.yang.bookclub.services.BookService;
import com.yang.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/books/new")
	public String index(@ModelAttribute("books") Books book,
	         Model model,
	         HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		
		if (userId != null) {
			User loggedUser = userService.findUser(userId);
            model.addAttribute("loggedUser", loggedUser);
            return "createBook.jsp";
		} else {
			return "redirect:/";
		}
	}
		 
	
	
	@PostMapping("/books/create")
	public String createBooks(
			@Valid @ModelAttribute("books") Books book,
            BindingResult result,
            Model model,
            HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (result.hasErrors()) {
			User loggedUser = userService.findUser(userId);
			model.addAttribute("loggedUser", loggedUser);
			model.addAttribute("books", book);
            return "createBook.jsp";
        } else {
        	User loggedUser = userService.findUser(userId);
        	model.addAttribute("loggedUser", loggedUser);
        	book.setUser(loggedUser);
            bookService.createBook(book);
            return "redirect:/books";
        }
		
	}
	
	@GetMapping("/books/{id}/edit")
    public String editBook(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {
        // route guard
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            Books book = bookService.findBook(id);
            model.addAttribute("book", book);
            model.addAttribute("users", userService.allUsers());
            return "editBook.jsp";
        } else {
            return "redirect:/";
        }
    }

    
    @PutMapping("/books/{id}/edit")
    public String updateBook(
            @Valid @ModelAttribute("book") Books book,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            List<User> users = userService.allUsers();
            model.addAttribute("users", users);
            return "editBook.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books/{id}";
        }
    }
    @DeleteMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/books/{id}")
    public String viewOne(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            User loggedUser = userService.findUser(userId);
            model.addAttribute("loggedUser", loggedUser);
            Books book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "showOne.jsp";
        } else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/bookmarket")
    public String market(
    		HttpSession session,
    		Model model
    		
    		) {
    	Long userId = (Long) session.getAttribute("user_id");
    	
    	if (userId != null) {
    		User loggedUser = userService.findUser(userId);
    		model.addAttribute("loggedUser", loggedUser);
    		List<Books> books = bookService.allBooks();
    		List<Books> borrowedBooks = loggedUser.getBorrowedBooks();
    		model.addAttribute("books", books);
            model.addAttribute("borrowedBooks", borrowedBooks);
    		
            return "bookmarket.jsp";
    	}else {
    		return "redirect:/";
    	}
    	
    	
    }
    
    @PutMapping("/books/{id}/borrow")
    public String borrowBook(
            @PathVariable("id") Long id,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User borrower = userService.findUser(userId);
        Books book = bookService.findBook(id);
        book.setBorrower(borrower);
        bookService.createBook(book);
        return "redirect:/bookmarket";
    }
    @PutMapping("/books/{id}/return")
    public String returnBook(
            @PathVariable("id") Long id,
            HttpSession session) {
        Books book = bookService.findBook(id);
        book.setBorrower(null);
        bookService.createBook(book);
        return "redirect:/bookmarket";
    }
    

}
