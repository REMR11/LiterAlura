package com.SpringAlura.LiterAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.SpringAlura.LiterAlura.principal.Principal;
import com.SpringAlura.LiterAlura.repository.AuthorRepository;
import com.SpringAlura.LiterAlura.repository.BookRepository;
import com.SpringAlura.LiterAlura.repository.TranslatorRepository;

@SpringBootApplication
public  class LiterAluraApplication implements CommandLineRunner{
//	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private TranslatorRepository translatorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository, authorRepository, translatorRepository);
		principal.muestraElMenu();
		
	}



}
