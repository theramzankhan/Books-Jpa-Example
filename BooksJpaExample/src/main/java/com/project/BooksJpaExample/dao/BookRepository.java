package com.project.BooksJpaExample.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.BooksJpaExample.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);

}
