package com.yang.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.bookclub.models.Books;
import com.yang.bookclub.repository.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
	
	public List<Books> allBooks() {
        return bookRepository.findAll();
    }
	
	public Books createBook(Books b) {
        return bookRepository.save(b);
    }
	
	
	public Books findBook(Long id) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else
            return null;
    }
	
	
	public Books updateBook(Books books) {
        Optional<Books> optionalBook = bookRepository.findById(books.getId());
        if (optionalBook.isPresent()) {
            return bookRepository.save(books);
        } else
            return null;
    }
	public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
