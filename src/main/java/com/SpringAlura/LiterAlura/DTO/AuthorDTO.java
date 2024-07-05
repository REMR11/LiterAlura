package com.SpringAlura.LiterAlura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorDTO(/**
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
		@JsonAlias("death_year") Integer deathYear) {

}
