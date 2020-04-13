package org.casadocodigo.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.models.Book;

@Model
public class AdminBooksController {
	
	private Book product = new Book();
	
	@Inject
	private BookDAO bookDAO;
	
	public void save() {
		bookDAO.save(product);
	}

	public Book getProduct() {
		return product;
	}
}
