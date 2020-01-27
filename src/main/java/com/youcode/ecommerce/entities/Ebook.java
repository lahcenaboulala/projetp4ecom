package com.youcode.ecommerce.entities;

import java.io.File;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Ebook extends AuditEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	private float price;
	private String keyword;
	private File file;
	private String cover;
	private int sell_count;
	private int stock;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	@JsonIgnore
	private Author author;

	@OneToMany(mappedBy = "ebook", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@NotNull
	private List<Review> reviews;

	@OneToMany(mappedBy = "ebook", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@NotNull
	private List<Order> orders;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private Category category;

}
