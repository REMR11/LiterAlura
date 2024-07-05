package com.SpringAlura.LiterAlura.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="author")
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private Integer birthYear;
	private Integer deathYear;

	@ManyToOne
    private Book book;
	
	public Author() {
		
	}
	
	public Author(AuthorsData pAuthorsData) {
		this.name = pAuthorsData.name();
		this.birthYear = pAuthorsData.birthYear();
		this.deathYear = pAuthorsData.deathYear();
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (birthYear != null) {
			builder.append("birthYear=");
			builder.append(birthYear);
			builder.append(", ");
		}
		if (deathYear != null) {
			builder.append("deathYear=");
			builder.append(deathYear);
			builder.append(", ");
		}
		if (book != null) {
			builder.append("books=");
			builder.append(book);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthYear
	 */
	public Integer getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the deathYear
	 */
	public Integer getDeathYear() {
		return deathYear;
	}

	/**
	 * @param deathYear the deathYear to set
	 */
	public void setDeathYear(Integer deathYear) {
		this.deathYear = deathYear;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	
}
