package com.yang.bookclub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yang.bookclub.models.Books;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
	List<Books> findAll();
}
