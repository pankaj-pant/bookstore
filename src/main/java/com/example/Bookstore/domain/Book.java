package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String isbn;
	private String title;
	private String author;
	private int year;
	private double price;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Book() {
		
	}

	public Book(String isbn, String title, String author, int year, double price, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.category = category;
		
	}

	public long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}


	public void setId(long id) {
		this.id = id;
	}





	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public void setYear(int year) {
		this.year = year;
	}





	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + "]";
	}


	
}
