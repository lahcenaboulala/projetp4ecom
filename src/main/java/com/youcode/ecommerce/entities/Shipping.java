package com.youcode.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shipping extends AuditEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ship_name")
	@Size(min = 3, max = 52)
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@NotBlank
	private String shipName;

	@Column(name = "ship_address")
	@Size(min = 3, max = 240)
	@Pattern(regexp = "[0-9a-zA-Z #,-]+")
	@NotBlank
	private String shipAddress;

	@Column(name = "ship_address2")
	@Pattern(regexp = "[0-9a-zA-Z #,-]+")
	@Size(min = 3, max = 240)
	private String shipAddress2;

	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	@JsonIgnore
	private OrderDetail orderDetail;

}
