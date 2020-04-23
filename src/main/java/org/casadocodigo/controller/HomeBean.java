package org.casadocodigo.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.models.Book;

@Model
public class HomeBean {
	
	@Inject
	private BookDAO bookDAO;
	
	public List<Book> lastReleases(){
		return bookDAO.lastReleases();
	}
	
	public List<Book> olderBooks(){
		return bookDAO.olderBooks();
	}
}
