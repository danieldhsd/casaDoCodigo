package org.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.models.Book;

public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Book product) {
		manager.persist(product);
	}

	public List<Book> list() {
		return manager.createQuery("select distinct(obj) from Book obj join fetch obj.authors", 
				Book.class).getResultList();
	}

}
