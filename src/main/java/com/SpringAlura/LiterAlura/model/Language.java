package com.SpringAlura.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Enumeración que representa los idiomas soportados por la aplicación.
 */
public enum Language {
    /**
     * Idioma inglés.
     */
    ENGLISH("en", "Inglés"),
    /**
     * Idioma francés.
     */
    FRENCH("fr", "Francés"),
    /**
     * Idioma alemán.
     */
    GERMAN("de", "Alemán"),
    /**
     * Idioma italiano.
     */
    ITALIAN("it", "Italiano"),
    /**
     * Idioma español.
     */
    SPANISH("es", "Español"),
    /**
     * Idioma holandés.
     */
    DUTCH("nl", "Holandés"),
    /**
     * Idioma portugués.
     */
    PORTUGUESE("pt", "Portugués"),
    /**
     * Idioma ruso.
     */
    RUSSIAN("ru", "Ruso"),
    /**
     * Idioma chino.
     */
    CHINESE("zh", "Chino"),
    /**
     * Idioma japonés.
     */
    JAPANESE("ja", "Japonés");

    /**
     * Código ISO del idioma.
     */
    private String code;
    /**
     * Nombre del idioma en español.
     */
    private String codeSpanish;

    /**
     * Constructor que inicializa el código ISO y el nombre del idioma en español.
     * 
     * @param code Código ISO del idioma.
     * @param codeSpanish Nombre del idioma en español.
     */
    Language(String code, String codeSpanish) {
        this.code = code;
        this.codeSpanish = codeSpanish;
    }

    /**
     * Devuelve el idioma que coincide con el código ISO proporcionado.
     * 
     * @param text Código ISO del idioma.
     * @return El idioma que coincide con el código ISO, o null si no se encuentra.
     */
    public static List<Language> fromString(List<String> codes) {
    	List<Language> languages = new ArrayList();
    	for (String code : codes) {
    		for (Language language : Language.values()) {
                if (language.code.equalsIgnoreCase(code)) {
                    languages.add(language);
                }
            }
		}
    	
    	return languages;
    }

    /**
     * Devuelve el idioma que coincide con el nombre del idioma en español proporcionado.
     * 
     * @param text Nombre del idioma en español.
     * @return El idioma que coincide con el nombre del idioma en español, o null si no se encuentra.
     */
    public static List<Language> fromEspanol(List<String> codes) {
    	List<Language> languages = new ArrayList();
    	for (String code : codes) {
    		for (Language language : Language.values()) {
                if (language.codeSpanish.equalsIgnoreCase(code)) {
                    languages.add(language);
                }
            }
		}
    	return languages;
        
    }
}