package org.casadocodigo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.models.Book;

@Model
public class AdminListBooksController {
	
	@Inject
	private BookDAO bookDAO;
	
	private List<Book> books = new ArrayList<Book>();
	
	@PostConstruct
	private void init() {
		this.books = bookDAO.list();
	}
	public List<Book> getBooks() {
		return books;
	}
	
	
}
