package com.SpringAlura.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SpringAlura.LiterAlura.model.Author;

@Service
public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByNameContainingIgnoreCase(String pAuthorName);
	List<Author> findByYirthYear(Integer pbirthYear);
}
