package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class PaymentDetailsDTO {

	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del pago")
	private int paymentId;
	@JsonProperty("empleado")
	@NotBlank
	@ApiModelProperty(value = "Nombre del empleado")
	private String empleado;
	@JsonProperty("total")
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "Un máximo de 3 dígitos enteros y 2 decimales")
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de pago")
	private Date fecha;


	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate());
	}
}
