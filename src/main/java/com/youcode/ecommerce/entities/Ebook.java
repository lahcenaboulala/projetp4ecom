package com.youcode.ecommerce.entities;

import java.io.File;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

	private static final long serialVersionUID = -5831965219601389347L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	private float price;
	private String keyword;
	private File file;
	private String cover;
	private int sellCount;
	private int stock;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	@JsonIgnore
	private Author author;

	@OneToMany(mappedBy = "ebook", cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private List<Review> reviews;

	@OneToMany(mappedBy = "ebook", cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private List<Order> orders;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private Category category;

	public Ebook() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Ebook [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", keyword=" + keyword + ", file=" + file + ", cover=" + cover + ", sell_count=" + sellCount
				+ ", stock=" + stock + ", author=" + author + ", reviews=" + reviews + ", orders=" + orders
				+ ", category=" + category + "]";
	}

}
