package com.example.application.dtos;

import java.math.BigDecimal;
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class PaymentEditDTO {

	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del pago")
	private int paymentId;
	@JsonProperty("empleado")
	@Positive
	@ApiModelProperty(value = "Nombre del empleado")
	private int empleado;
	@JsonProperty("total")
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "Un máximo de 3 dígitos enteros y 2 decimales")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de pago")
	private Date fecha;

	public static PaymentEditDTO from(Payment source) {
		return new PaymentEditDTO(
				source.getPaymentId(),
				source.getStaff().getStaffId(),
				source.getAmount(),
				source.getPaymentDate());
	}
	
	public static Payment from(PaymentEditDTO source, Rental rental) {
		return new Payment(
				source.getPaymentId(),
				source.getAmount(),
				source.getFecha(),
				new Staff( source.getEmpleado()),
				rental
				);
	}
}
