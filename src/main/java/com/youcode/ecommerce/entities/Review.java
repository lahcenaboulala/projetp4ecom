package com.youcode.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review extends AuditEntities {

	private static final long serialVersionUID = 4130124328775500170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int rank;

	private String comment;

	@ManyToOne
	@JoinColumn(name = "ebook_id")
	@JsonIgnore
	private Ebook ebook;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnore
	private Client client;

	public Review() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Ebook getEbook() {
		return ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rank=" + rank + ", comment=" + comment + ", ebook=" + ebook + ", client="
				+ client + "]";
	}

}
