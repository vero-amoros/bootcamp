package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;

	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal amount;

	@Column(name="last_update")
	@Generated(value = GenerationTime.ALWAYS)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Timestamp lastUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_date")
	@PastOrPresent
	@NotNull
	private Date paymentDate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	@NotNull
	private Customer customer;

	//bi-directional many-to-one association to Rental
	@ManyToOne
	@NotNull
	@JoinColumn(name="rental_id")
	private Rental rental;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="staff_id")
	@NotNull
	private Staff staff;

	public Payment() {
	}

	
	public Payment(int paymentId,
			@NotNull @DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 5, fraction = 2) BigDecimal amount,
			@PastOrPresent @NotNull Date paymentDate,  @NotNull Staff staff, @NotNull Rental rental) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.staff = staff;
		this.rental = rental; //este hay que quitarlo?? TODO
		if(rental!=null)
			this.customer = rental.getCustomer();
	}


	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Rental getRental() {
		return this.rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Payment))
			return false;
		Payment other = (Payment) obj;
		return paymentId == other.paymentId;
	}
	
	

}