package com.youcode.ecommerce.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category extends AuditEntities {

	private static final long serialVersionUID = -2041894579972741705L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private List<Category> subCategories;

	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	private List<Ebook> ebooks;

	public Category() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ebook> getEbooks() {
		return ebooks;
	}

	public void setEbooks(List<Ebook> ebooks) {
		this.ebooks = ebooks;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

}
