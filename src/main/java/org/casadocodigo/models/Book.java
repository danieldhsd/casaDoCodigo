package org.casadocodigo.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String title;
	
	@Lob
	@NotBlank
	@Length(min = 10)
	private String description;
	
	@Min(50)
	private Integer numberOfPages;
	
	@DecimalMin("20")
	private BigDecimal price;
	
	@ManyToMany
	@Size(min = 1)
	@NotNull
	private List<Author> authors = new ArrayList<>();
	
	public void add(Author author){
		authors.add(author);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", numberOfPages="
				+ numberOfPages + ", price=" + price + "]";
	}

	public List<Author> getAuthors() {
		return authors;
	}
	
}
