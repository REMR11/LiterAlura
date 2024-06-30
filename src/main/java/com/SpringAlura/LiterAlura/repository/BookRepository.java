package com.SpringAlura.LiterAlura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.SpringAlura.LiterAlura.model.Book;
import com.SpringAlura.LiterAlura.model.Language;

@Service
public interface BookRepository extends JpaRepository<Book, Long>{
	Optional<Book> findByTitleContainingIgnoreCase(String NameBook);
	List<Book>findByLanguages(Language pLanguage);
	@Query("select b from Book b WHERE b.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
    List<Book> seriesPorTemporadaYEvaluacion(int totalTemporadas, double evaluacion);
}
