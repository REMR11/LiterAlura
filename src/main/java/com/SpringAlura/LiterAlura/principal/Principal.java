package com.SpringAlura.LiterAlura.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.SpringAlura.LiterAlura.DTO.AuthorDTO;
import com.SpringAlura.LiterAlura.DTO.BookDTO;
import com.SpringAlura.LiterAlura.model.ApiData;
import com.SpringAlura.LiterAlura.model.Author;
import com.SpringAlura.LiterAlura.model.AuthorsData;
import com.SpringAlura.LiterAlura.model.Book;
import com.SpringAlura.LiterAlura.model.BookData;
import com.SpringAlura.LiterAlura.model.Language;
import com.SpringAlura.LiterAlura.model.TranslatorsData;
import com.SpringAlura.LiterAlura.repository.AuthorRepository;
import com.SpringAlura.LiterAlura.repository.BookRepository;

import com.SpringAlura.LiterAlura.service.ConsumeApi;
import com.SpringAlura.LiterAlura.service.ConvertData;
import com.SpringAlura.LiterAlura.service.BookService;

public class Principal {
	private Scanner sc = new Scanner(System.in);
	private ConsumeApi consumeApi = new ConsumeApi();
	private final String URL_BASE = "https://gutendex.com/books/";
	private ConvertData convertData = new ConvertData();
//	private ApiData apiData = new ApiData();
	private List<BookData> bookDatas = new ArrayList<BookData>();
	private List<AuthorsData> authorDatas = new ArrayList<AuthorsData>();
	private List<TranslatorsData> translatorsDatas = new ArrayList<TranslatorsData>();

	private List<Book> books = new ArrayList<Book>();
	private List<Author> authors = new ArrayList<Author>();

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	private BookService bookSerie;

	public Principal(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public void muestraElMenu() {
		var opcion = -1;
		while (opcion != 0) {
			var menu = """
					1 -> Buscar Libro
                    2 -> Listar Libros Registrados
                    3 -> Listar Autores Registrados
                    4 -> Listar Autores Vivos En Un Determinado Año
                    5 -> Listar Libros por idioma

					0 - Salir
					""";
			System.out.println(menu);
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				searchBookByTitle();
				break;
			case 2:
				showBooks();
				break;
			case 3:
				showAuthors();
				break;
			case 4:
				showAuthorAlive();
				break;
			case 5:
				ShowBookByLanguage();
				break;
			case 0:
				System.out.println("Cerrando la aplicación...");
				break;
			default:
				System.out.println("Opción inválida");
			}
		}
	}

	private ApiData getData() {
		System.out.println("Escribe el nombre del libro que deseas buscar: ");
		String tituloLibro = sc.nextLine();
		String json = consumeApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+").toLowerCase());
		System.out.println(json);

		ApiData datos = convertData.getData(json, ApiData.class);

		System.out.println(datos);
		return datos;
	}

	private void searchBookByTitle() {
		ApiData apidata = getData();

		bookDatas = apidata.results().stream().map(b -> new BookData(b.title(), b.Authors(), b.Languages(),
				b.copyright(), b.mediaType(), b.downloadCount())).collect(Collectors.toList());
		bookDatas.forEach(System.out::println);

		List<Book> booksApi = new ArrayList<Book>();
		for (BookData bookData : bookDatas) {

			List<Author> author = bookData.Authors().stream().map(a -> new Author(a)).collect(Collectors.toList());

			System.out.println(author);
			Book bookdatos = new Book(bookData);
			bookdatos.setAuthor(author);

			booksApi.add(bookdatos);
		}

		booksApi.forEach(bookRepository::save);

		booksApi.forEach(System.out::println);

	}

	public void showBooks() {
		books = bookRepository.findAll();
		List<BookDTO> booksDTO = books.stream().map(b -> new BookDTO(b.getTitle(), b.getLanguage(), b.getCopyright(),
				b.getMediaType(), b.getDownloadCount())).collect(Collectors.toList());

		booksDTO.forEach(System.out::println);

	}

	public void showAuthors() {
		authors = authorRepository.findAll();

		List<AuthorDTO> authorsDTO = authors.stream()
				.map(a -> new AuthorDTO(a.getName(), a.getBirthYear(), a.getDeathYear())).collect(Collectors.toList());

		authorsDTO.forEach(System.out::println);
	}

	public void showAuthorAlive() {
		System.out.println("Ingresa el año a consultar:");
		Integer year = sc.nextInt();
		authors = authorRepository.showAuthorsAlive(year);

		if (authors.isEmpty()) {
			System.out.println("Sin autores vivos en el año indicado...\n");
			return;
		} else {
			authors.forEach(System.out::println);
		}
	}

	public void ShowBookByLanguage() {
		System.out.println("""
				Escriba el idioma del libro:
				es: Español
				en: Inglés
				fr: Francés
				it: Italiano
				pt: Portugues
				de: Alemán
				nl: Holandés
				ru: Ruso
				zh: Chino
				ja: Japonés
				""");

		String idiomaSelecionado = sc.nextLine();
		sc.nextLine();

		Language language = Language.fromString(idiomaSelecionado);

//		books = bookRepository.findAllByLanguage(language);
		books = bookRepository.findAll();
		List<Book> booksLanguage = books.stream()
				.filter(l -> l.getLanguage().equals(language))
				.collect(Collectors.toList());
		
		if (booksLanguage .isEmpty()) {
			System.out.println("No se encontraron libros en el idioma seleccionado...\n");
			return;
		} else {
			List<BookDTO> booksdt = booksLanguage .stream().map(l -> new BookDTO(l.getTitle(), l.getLanguage(), l.getCopyright(),
					l.getMediaType(), l.getDownloadCount())).collect(Collectors.toList());

			booksdt.forEach(System.out::println);
		}
	}
}
