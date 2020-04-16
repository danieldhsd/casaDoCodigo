package org.casadocodigo.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.models.Book;

@Model
public class AdminBooksController {
	
	private Book product = new Book();
	
	@Inject
	private BookDAO bookDAO;
	
	@Transactional
	public void save() {
		bookDAO.save(product);
	}

	public Book getProduct() {
		return product;
	}
}
