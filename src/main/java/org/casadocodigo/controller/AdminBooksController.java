package org.casadocodigo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.casadocodigo.dao.AuthorDAO;
import org.casadocodigo.dao.BookDAO;
import org.casadocodigo.infra.MessagesHelper;
import org.casadocodigo.models.Author;
import org.casadocodigo.models.Book;

@Model
public class AdminBooksController {

	private Book product = new Book();

	@Inject
	private BookDAO bookDAO;
	@Inject
	private AuthorDAO authorDAO;
	@Inject
	private MessagesHelper messagesHelper;
	
	private Part summary;
	
	
	private List<Author> authors = new ArrayList<Author>();
	private List<Integer> selectedAuthorsIds = new ArrayList<>();

	@PostConstruct
	public void init() {
		this.authors = authorDAO.list();
	}

	@Transactional
	public String save() throws IOException {
		
		summary.write("/home/danieldhsd/casadocodigo/livros/" + summary.getSubmittedFileName());
		
		bookDAO.save(product);
		
		messagesHelper.addFlash(new FacesMessage("Livro Gravado com Sucesso"));
		
		return "/produtos/lista?faces-redirect=true";
	}
	
	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
	
	public Book getProduct() {
		return product;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}

	public Part getSummary() {
		return summary;
	}

	public void setSummary(Part summary) {
		this.summary = summary;
	}
}
