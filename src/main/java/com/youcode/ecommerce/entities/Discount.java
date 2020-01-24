package com.youcode.ecommerce.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Discount extends AuditEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;

	private int percent;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expi_date;

}
