package org.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.models.Book;

@Model
public class BookDetailController {
	
	@Inject
	private BookDAO bookDAO;
	
	private Book book;
	
	private Integer id;
	
	public void loadDetail() {
		this.setBook(bookDAO.searchById(id));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
