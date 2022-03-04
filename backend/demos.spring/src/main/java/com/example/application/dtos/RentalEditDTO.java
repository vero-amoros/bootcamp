package com.example.application.dtos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Positive;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "Alquiler editable", description = "Version editable de los alquileres.")
public class RentalEditDTO {

	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler")
	private int rentalId;
	@JsonProperty("cliente")
	@Positive
	@ApiModelProperty(value = "Identificador del cliente")
	private int customer;
	@JsonProperty("pelicula")
	@Positive
	@ApiModelProperty(value = "Identificador de la película en el inventario")
	private int inventory; // vamos a sacar el id de la pelicula del inventario
	@Positive
	@ApiModelProperty(value = "Identificador del empleado")
	private int empleado; // staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de alquiler de la película")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de devolución de la película")
	private Date returnDate;
	@ApiModelProperty(value = "Lista de pagos")
	private List<PaymentEditDTO> payments;

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(), 
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(), 
				source.getStaff().getStaffId(), 
				source.getRentalDate(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				source.getPayments().stream().map(pago -> PaymentEditDTO.from(pago)).toList());
	}

	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(), 
				source.getRentalDate(), 
				new Inventory(source.getInventory()),
				new Customer(source.getCustomer()), 
				source.getReturnDate(), 
				new Staff(source.getEmpleado()));
	}

	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setCustomer(new Customer(customer));
		target.setInventory(new Inventory(inventory));
		target.setStaff(new Staff(empleado));
		
		//Borra los alquileres que sobran
		var delAlquiladas = target.getPayments().stream()
				.filter(item -> payments.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
				.toList();
		delAlquiladas.forEach(item -> target.removePayment(item));
		
		//Modifico los que han quedado
		target.getPayments().forEach(item -> { //item es lo de la base de datos y nuevo pago lo del DTO
			var nuevoPago = payments.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();//este es el que viene del DTO 
			if(item.getAmount() != nuevoPago.getAmount()) {
				item.setAmount(nuevoPago.getAmount());
			}
			if(item.getPaymentDate() != nuevoPago.getFecha()) {
				item.setPaymentDate(nuevoPago.getFecha());
			}
			
			if(item.getStaff().getStaffId() != nuevoPago.getEmpleado()) {
				item.setStaff(new Staff(nuevoPago.getEmpleado()));
			}
				
		});
		
		payments.stream()
		.filter(paymentDTO -> target.getPayments().stream().noneMatch(alquiler -> alquiler.getPaymentId() == paymentDTO.getPaymentId()))
		.forEach(paymentDTO -> target.addPayment(new Payment(
				paymentDTO.getPaymentId(),
				paymentDTO.getAmount(),
				paymentDTO.getFecha(),
				new Staff(paymentDTO.getEmpleado()),
				target)));
		return target;
	}
}
