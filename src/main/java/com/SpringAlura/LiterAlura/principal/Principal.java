package com.SpringAlura.LiterAlura.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.SpringAlura.LiterAlura.model.ApiData;
import com.SpringAlura.LiterAlura.model.Author;
import com.SpringAlura.LiterAlura.model.AuthorsData;
import com.SpringAlura.LiterAlura.model.Book;
import com.SpringAlura.LiterAlura.model.BookData;
import com.SpringAlura.LiterAlura.model.Translator;
import com.SpringAlura.LiterAlura.model.TranslatorsData;
import com.SpringAlura.LiterAlura.repository.AuthorRepository;
import com.SpringAlura.LiterAlura.repository.BookRepository;
import com.SpringAlura.LiterAlura.repository.TranslatorRepository;
import com.SpringAlura.LiterAlura.service.ConsumeApi;
import com.SpringAlura.LiterAlura.service.ConvertData;

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
	private List<Translator> translators = new ArrayList<Translator>();

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private TranslatorRepository translatorRepository;

	public Principal(BookRepository bookRepository, AuthorRepository authorRepository,
			TranslatorRepository translatorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.translatorRepository = translatorRepository;
	}

	public void muestraElMenu() {
		var opcion = -1;
		while (opcion != 0) {
			var menu = """
					1 - Buscar libro
					2 - Buscar episodios
					3 - Mostrar series buscadas
					4 - Buscar series por titulo
					5 - Top 5 mejores series
					6 - Buscar Series por categoría
					7 - filtrar series por temporadas y evaluación
					8 - Buscar episodios por titulo
					9 - Top 5 episodios por Serie

					0 - Salir
					""";
			System.out.println(menu);
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
            case 1:
            	searchBookByTitle();
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
        
        ApiData datos  = convertData.getData(json, ApiData.class);
        
        System.out.println(datos);
        return datos;
	}
	private void searchBookByTitle() {
		ApiData apidata = getData();
		
		bookDatas = apidata.results().stream()
				.map(b -> new BookData(
						b.title(), 
						b.Authors(), 
						b.translators(), 
						b.subjects(), 
						b.bookshelves(), 
						b.Languages(), 
						b.copyright(), 
						b.mediaType(), 
						b.downloadCount()))
				.collect(Collectors.toList());
		bookDatas.forEach(System.out::println);
		
		authorDatas = bookDatas.stream()
				.flatMap(b -> b.Authors().stream()
						.map(a -> new AuthorsData(
								a.name(), 
								a.birthYear(), 
								a.deathYear())))
				.collect(Collectors.toList());
		
		authorDatas.forEach(System.out::println);
	}
}
