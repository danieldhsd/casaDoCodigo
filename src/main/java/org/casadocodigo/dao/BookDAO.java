package org.casadocodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.models.Book;

public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Book product) {
		try {
			manager.getTransaction().begin();
			manager.persist(product);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
	}

}
