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
import com.elena.project.model.Client;
import com.elena.project.repository.BookRepository;
import com.elena.project.repository.ClientRepository;

@RestController
@RequestMapping(value="/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	 
	 @RequestMapping(value="/all", method=RequestMethod.GET)	
	 public ResponseEntity<List> getAllClients() {
		
		 return new ResponseEntity<List>((List) clientRepository.findAll(), new HttpHeaders(), HttpStatus.OK);
	}
	  
	 @RequestMapping(value="/{id}", method=RequestMethod.GET)	
	 public ResponseEntity<?> getClientById(@PathVariable("id") int id) {
		 if(clientRepository.findOne(id)== null) {
			 return new ResponseEntity<String>("Client doesn't exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
		 }
		 else {
			 return new ResponseEntity<Client>(clientRepository.findOne(id), new HttpHeaders(), HttpStatus.OK);
			 
		 }  
	}
	 
	 
	 
	 @RequestMapping(value="/{clientId}/{bookId}", method=RequestMethod.PUT) 
	 public ResponseEntity<?> addBookForClient(@PathVariable("clientId") int clientId, @PathVariable("bookId")int bookId) {
		
		 if(bookRepository.findOne(bookId).checkStock()==false) {
			 return new ResponseEntity<String>("Book is not available right now", new HttpHeaders(), HttpStatus.INSUFFICIENT_STORAGE);
			 
		 }
		 else {
		 clientRepository.findOne(clientId).borrowBook(bookRepository.findOne(bookId));
		 bookRepository.findOne(bookId).decrementStock();
		 clientRepository.save(clientRepository.findOne(clientId));
		 bookRepository.save(bookRepository.findOne(bookId));
		 return new ResponseEntity<Client>(clientRepository.findOne(clientId), new HttpHeaders(), HttpStatus.OK);
		 }
		 
	 }
	
	

}
