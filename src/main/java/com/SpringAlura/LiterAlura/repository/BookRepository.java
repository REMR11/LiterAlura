package com.SpringAlura.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringAlura.LiterAlura.model.Book;
import com.SpringAlura.LiterAlura.model.Language;

public interface BookRepository extends JpaRepository<Book, Long> {
//	Optional<Book> findByTitleContainingIgnoreCase(String NameBook);
//	@Query("SELECT b FROM book b WHERE b.Language = :language")
//	List<Book> findByLanguages(Language language);
	
//	@Query("SELECT b FROM Book b WHERE b.language = :language")
//	List<Book> findAllByLanguage(Language language);

//	List<Book> findTop5ByOrderByDownloadCountDesc();
//
//	@Query("SELECT l FROM book a JOIN a.authors l")
//	List<Author> showAuthors();
//
//	@Query("SELECT l FROM Book a JOIN a.authors l WHERE l.birthYear <= :year AND l.deathYear >= :year")
//	List<Author> showAuthorAlive (String year);
//	@Query("SELECT l FROM Book a JOIN a.authors l WHERE l.birthYear <= :year AND l.deathYear >= :year")
//	List<Author> showAuthorsAlive (@Param("year") int year);
	
	
}
