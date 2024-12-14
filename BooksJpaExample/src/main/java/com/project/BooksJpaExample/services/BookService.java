package com.project.BooksJpaExample.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.BooksJpaExample.dao.BookRepository;
import com.project.BooksJpaExample.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//get all books
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		this.bookRepository.findAll().forEach(list::add); //type cast kar rahe hai, parent class(Iterable) ko child class(List) me hum typecaste kar sakte hai
		return list;
	}
	
	
	//get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	//adding the book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	
	
	//delete book
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
	
	//update the book
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
	}

}
