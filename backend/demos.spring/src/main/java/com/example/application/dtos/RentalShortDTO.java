package com.example.application.dtos;

import javax.validation.constraints.NotBlank;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class RentalShortDTO {
	
	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler")
	private int rentalId;
	@JsonProperty("cliente")
	@NotBlank
	@ApiModelProperty(value = "Nombre del cliente")
	private String customer;
	@JsonProperty("titulo")
	@NotBlank
	@ApiModelProperty(value = "Título de la película")
	private String title;
	
	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle()
				);
	}
}
