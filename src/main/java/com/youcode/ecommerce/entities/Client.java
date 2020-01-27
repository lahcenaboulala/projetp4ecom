package com.youcode.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Client extends User {

	private static final long serialVersionUID = -5500533206342276021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	@Size(min = 3, max = 52)
	private String email;

	@Column(name = "first_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String firstName;

	@Column(name = "last_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String lastName;

	@Column(name = "city")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 100)
	private String city;

	@Column(name = "state")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 40)
	private String state;

	@Column(name = "zip")
	@Pattern(regexp = "^[0-9]*$")
	@Size(min = 5, max = 6)
	private String zip;

	@Column(name = "email_verified")
	private Integer emailVerified;

	@Column(name = "phone")
	@Pattern(regexp = "[0-9]+")
	@Size(min = 11, max = 12)
	private String phone;

	@Column(name = "country")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 40)
	private String country;

	@Column(name = "address")
	@Pattern(regexp = "[0-9a-zA-Z #,-]+")
	@Size(min = 3, max = 240)
	private String address;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@NotNull
	private List<Review> reviews;

	@OneToMany
	@JoinColumn(name = "order_detail_id")
	private List<OrderDetail> orderDetails;

}
