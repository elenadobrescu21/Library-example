package com.elena.project.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elena.project.model.Book;

public interface BookService {
	
	 Book loadBookByName (String name);

	 Serializable post(Book book);

	 Book get(int id);
	 
	 List findAll();
	 
	 List findBookByAuthor(String author);

	
	 

}
