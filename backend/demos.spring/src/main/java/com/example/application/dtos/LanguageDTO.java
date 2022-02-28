package com.example.application.dtos;

import com.example.domains.entities.Language;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {
	@JsonProperty("id")
	private int languageId;
	@JsonProperty("idioma")
	private String name;
	
	public static Language from(LanguageDTO source) {
		return new Language(
				source.getLanguageId(),
				source.getName()
				);
	}
	
	public static LanguageDTO from(Language source) {
		return new LanguageDTO(
				source.getLanguageId(),
				source.getName()
				);
	}

}
