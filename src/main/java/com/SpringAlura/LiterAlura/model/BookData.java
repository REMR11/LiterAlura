package com.SpringAlura.LiterAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
		@JsonAlias("title") String title, 
		@JsonAlias("authors") List<AuthorsData> Authors,
		@JsonAlias("translators") List<TranslatorsData> translators, 
		@JsonAlias("subjects") List<String> subjects,
		@JsonAlias("bookshelves") List<String> bookshelves,
		@JsonAlias("languages") List<String> Languages, 
		@JsonAlias("copyright") Boolean copyright, 
		@JsonAlias("media_type") String mediaType,
		@JsonAlias("download_count") Integer downloadCount) {

}
