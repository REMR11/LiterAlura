package com.SpringAlura.LiterAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Representa una lista de traductores.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TranslatorsData(
		/**
		 * Nombre de la persona.
		 */
		@JsonAlias("name") String name,
		/**
		 * Año de nacimiento de la persona.
		 */
		@JsonAlias("birth_year") Integer birthYear, 
		
		/**
         * Año de fallecimiento de la persona, puede ser null si la persona aún está viva.
         */
		@JsonAlias("death_year") Integer deathYear) {}
