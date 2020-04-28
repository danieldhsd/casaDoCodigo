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

	public List<Book> lastReleases() {
		return manager.createQuery("select obj from Book obj order by obj.releaseDate desc", 
				Book.class).setMaxResults(5).getResultList();
	}

	public List<Book> olderBooks() {
		return manager.createQuery("select obj from Book obj", Book.class)
				.setMaxResults(20).getResultList();
	}

	public Book searchById(Integer id) {
		String query = "select obj from Book obj join fetch obj.authors "
				+ " where obj.id = :ID";

		return manager.createQuery(query, Book.class)
				.setParameter("ID", id)
				.getSingleResult();
	}
}
