package com.SpringAlura.LiterAlura.DTO;

import com.SpringAlura.LiterAlura.model.Language;

public record BookDTO(String title,
	Language languages, 
	Boolean copyright,
	String mediaType,
	Integer downloadCount) {}
