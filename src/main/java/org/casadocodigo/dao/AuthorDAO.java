package org.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.models.Author;

public class AuthorDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Author> list(){
		return manager.createQuery(
				"select obj from Author obj order by obj.name asc", Author.class)
				.getResultList();
	}
}
