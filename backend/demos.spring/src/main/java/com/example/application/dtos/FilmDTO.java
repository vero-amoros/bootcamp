package com.example.application.dtos;

import com.example.domains.entities.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FilmDTO {
	@JsonProperty("id")
	private int FilmId;
	
	public static Film from(FilmDTO source) {
		return new Film(
				source.getFilmId()
				);
	}
	
	public static FilmDTO from(Film source) {
		return new FilmDTO(
				source.getFilmId()
				);
	}
	
}
