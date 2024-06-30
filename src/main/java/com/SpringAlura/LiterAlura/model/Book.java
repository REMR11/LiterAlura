package com.SpringAlura.LiterAlura.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	@ManyToMany
	@JoinTable(
			name = "book_author", 
			joinColumns = 
				@JoinColumn(name = "book_id"), 
			inverseJoinColumns = 
				@JoinColumn(name = "author_id"))
	private List<Author> Authors;
	@ManyToMany
	@JoinTable(
			name = "book_translator", 
			joinColumns = 
				@JoinColumn(name = "book_id"), 
			inverseJoinColumns = 
				@JoinColumn(name = "translator_id"))
	private List<Translator> translators;
	@ElementCollection
	@CollectionTable(
			name = "book_subject", 
			joinColumns = 
				@JoinColumn(name = "book_id"))
	private List<String> subjects;
	@ElementCollection
	@CollectionTable(
			name = "book_bookshelves", 
			joinColumns = 
				@JoinColumn(name = "book_id"))
	private List<String> bookshelves;
	 @Enumerated(EnumType.STRING)
	private List<Language> Languages;
	private Boolean copyright;
	private String mediaType;
	private Integer downloadCount;

	public Book() {
	}

	public Book(BookData pBookData) {
		this.title = pBookData.title();
		this.subjects = pBookData.subjects();
		this.bookshelves = pBookData.bookshelves();
		this.Languages = Language.fromString(pBookData.Languages());
		this.copyright = pBookData.copyright();
		this.mediaType = pBookData.mediaType();
		this.downloadCount =pBookData.downloadCount();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", ");
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (Authors != null) {
			builder.append("Authors=");
			builder.append(Authors);
			builder.append(", ");
		}
		if (translators != null) {
			builder.append("translators=");
			builder.append(translators);
			builder.append(", ");
		}
		if (subjects != null) {
			builder.append("subjects=");
			builder.append(subjects);
			builder.append(", ");
		}
		if (bookshelves != null) {
			builder.append("bookshelves=");
			builder.append(bookshelves);
			builder.append(", ");
		}
		if (Languages != null) {
			builder.append("Languages=");
			builder.append(Languages);
			builder.append(", ");
		}
		if (copyright != null) {
			builder.append("copyright=");
			builder.append(copyright);
			builder.append(", ");
		}
		if (mediaType != null) {
			builder.append("mediaType=");
			builder.append(mediaType);
			builder.append(", ");
		}
		if (downloadCount != null) {
			builder.append("downloadCount=");
			builder.append(downloadCount);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return Authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		Authors = authors;
	}

	/**
	 * @return the translators
	 */
	public List<Translator> getTranslators() {
		return translators;
	}

	/**
	 * @param translators the translators to set
	 */
	public void setTranslators(List<Translator> translators) {
		this.translators = translators;
	}

	/**
	 * @return the subjects
	 */
	public List<String> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	/**
	 * @return the bookshelves
	 */
	public List<String> getBookshelves() {
		return bookshelves;
	}

	/**
	 * @param bookshelves the bookshelves to set
	 */
	public void setBookshelves(List<String> bookshelves) {
		this.bookshelves = bookshelves;
	}

	/**
	 * @return the languages
	 */
	public List<Language> getLanguages() {
		return Languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<Language> languages) {
		Languages = languages;
	}

	/**
	 * @return the copyright
	 */
	public Boolean getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(Boolean copyright) {
		this.copyright = copyright;
	}

	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return the downloadCount
	 */
	public Integer getDownloadCount() {
		return downloadCount;
	}

	/**
	 * @param downloadCount the downloadCount to set
	 */
	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}
	
	
	
}
