package com.SpringAlura.LiterAlura.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringAlura.LiterAlura.DTO.BookDTO;
import com.SpringAlura.LiterAlura.model.Book;
import com.SpringAlura.LiterAlura.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<BookDTO> getDataBook(){
		return convertData(repository.findAll());
	}
	
	public List<BookDTO> convertData(List<Book> book){
		return book.stream()
				.map(b -> new BookDTO(
						b.getTitle(), 
						b.getLanguage(), 
						b.getCopyright(), 
						b.getMediaType(), 
						b.getDownloadCount()))
				.collect(Collectors.toList());
	}
}
