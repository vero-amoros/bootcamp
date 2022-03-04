package com.example.application.dtos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class RentalDetailsDTO {

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
	@NotBlank
	@ApiModelProperty(value = "Nombre del empleado")
	private String empleado; //staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de alquiler de la película")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de devolución de la película")
	private Date returnDate;
	@ApiModelProperty(value = "Lista de pagos")
	private List<PaymentDetailsDTO> payments;
	
	

	public static RentalDetailsDTO from(Rental source) {
		return new RentalDetailsDTO(
				source.getRentalId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments().stream().map(pago -> PaymentDetailsDTO.from(pago)).toList()
				);
	}
}
