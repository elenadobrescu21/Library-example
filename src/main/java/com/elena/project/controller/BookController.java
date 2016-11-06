package com.elena.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elena.project.model.Book;
import com.elena.project.repository.BookRepository;
import com.elena.project.repository.BookService;

@RestController
@RequestMapping(value="/book")
public class BookController {
	
	 @Autowired
	 private BookService bookService;
	 
	 @RequestMapping(value="/{name}", method=RequestMethod.GET)	
	 public ResponseEntity<?> getBookByName(@PathVariable("name") String name) {
		 if(bookService.loadBookByName(name)== null) {
			 return new ResponseEntity<String>("Book doesn't exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<Book>(bookService.loadBookByName(name), new HttpHeaders(), HttpStatus.OK);
			 
		 }  
	}
	 
	 @RequestMapping(value="/all", method=RequestMethod.GET)	
	 public ResponseEntity<List> getAllBooks() {
		
		 return new ResponseEntity<List>(bookService.findAll(), new HttpHeaders(), HttpStatus.OK);
	  
	}
	 
	 @RequestMapping(method=RequestMethod.POST)
	 public ResponseEntity<Book> addBook(@RequestBody Book book) {
		 bookService.post(book);
		 return new ResponseEntity<Book>(book, new HttpHeaders(), HttpStatus.OK);
		 
	 }
	 

}
