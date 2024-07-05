package com.SpringAlura.LiterAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
		@JsonAlias("title") String title, 
		@JsonAlias("authors") List<AuthorsData> Authors, 
		@JsonAlias("languages") List<String> Languages, 
		@JsonAlias("copyright") Boolean copyright, 
		@JsonAlias("media_type") String mediaType,
		@JsonAlias("download_count") Integer downloadCount) {

}
