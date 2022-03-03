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

import lombok.Value;

@Value
public class RentalEditDTO {

	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("cliente")
	private int customer;
	@JsonProperty("pelicula")
	private int inventory; //vamos a sacar el id de la pelicula del inventario
	private int empleado; //staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;
	private List<Integer> payments;
	
	

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate(),
				null
				);
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				new Inventory(source.getInventory()),
				new Customer(source.getCustomer()),
				source.getReturnDate(),
				new Staff(source.getEmpleado()),
				null
				);
	}
	
//	public Rental update(Rental target) {
//		target.setRentalId(rentalId);
//		target.setRentalDate(rentalDate);
//		target.setInventory(new Inventory(target.getInventory()));
//		target.setReturnDate(returnDate == null ? null : target.setReturnDate(returnDate));
//		
//		
//		
	
	
//		target.setReleaseYear(releaseYear);
//		if(target.getLanguage().getLanguageId() != language)
//			target.setLanguage(new Language(language));
//		target.setLanguageVO(languageVO == null ? null : new Language(languageVO));
//		target.setRentalDuration(rentalDuration);
//		target.setRentalRate(rentalRate);
//		target.setLength(length);
//		target.setReplacementCost(replacementCost);
//		target.setRating(rating == null ? null : Rental.Rating.getEnum(rating));
////ENTITY(1,3,5)
////DTO(1,7)
//		// Borra los actores que sobran
//		var delActores = target.getRentalActors().stream()
//				.filter(item -> !actores.contains(item.getActor().getActorId()))
//				.toList();
//		delActores.forEach(item -> target.removeRentalActor(item));
//		// Añade los actores que falta
//		actores.stream()
//			.filter(idActorDTO -> !target.getRentalActors().stream().anyMatch(RentalActor -> RentalActor.getActor().getActorId() == idActorDTO))
//			.forEach(idActorDTO -> target.addRentalActor(new Actor(idActorDTO)));
////			.forEach(idActorDTO -> {
////				var RentalActor = new RentalActor();
////				RentalActor.setRental(target);
////				RentalActor.setActor(new Actor(idActorDTO));
////				var pk = new RentalActorPK();
////				pk.setActorId(idActorDTO);
////				pk.setRentalId(RentalId);
////				RentalActor.setId(pk);
////				target.getRentalActors().add(RentalActor);
////			});
//		// Borra las categorias que sobran
//		var delCategorias = target.getRentalCategories().stream()
//				.filter(item -> !categorias.contains(item.getCategory().getCategoryId()))
//				.toList();
//		delCategorias.forEach(item -> target.removeRentalCategory(item));
//		// Añade las categorias que falta
//		categorias.stream()
//			.filter(idCategoriaDTO -> target.getRentalCategories().stream().noneMatch(RentalCategory -> RentalCategory.getCategory().getCategoryId() == idCategoriaDTO))
//			.forEach(idCategoriaDTO -> target.addRentalCategory(new Category(idCategoriaDTO)));
//		return target;
//	}
}
