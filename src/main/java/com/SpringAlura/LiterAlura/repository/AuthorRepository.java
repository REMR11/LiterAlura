package com.SpringAlura.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.SpringAlura.LiterAlura.model.Author;

@Service
public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByNameContainingIgnoreCase(String pAuthorName);
	List<Author> findByBirthYear(Integer pbirthYear);
	@Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND a.deathYear >= :year")
	List<Author> showAuthorsAlive (@Param("year") int year);
}
