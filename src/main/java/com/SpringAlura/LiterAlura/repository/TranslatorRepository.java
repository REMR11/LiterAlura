package com.SpringAlura.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringAlura.LiterAlura.model.Translator;

public interface TranslatorRepository extends JpaRepository<Translator, Long> {
	List<Translator> findByNameContainingIgnoreCase(String pAuthorName);
	List<Translator> findByBirthYear(Integer pbirthYear);
}
