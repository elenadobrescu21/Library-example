package com.elena.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="book")
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publishingHouse")
	private String publishingHouse;
	
	@Column(name="stock")
	private int stock;

	public Book() {
		
	}
	public Book(String name, String author, String publishingHouse, int stock) {
		super();
		this.name = name;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void decrementStock() {
		this.stock = this.stock - 1;
	}
	
	public boolean checkStock() {
		if(this.stock > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
