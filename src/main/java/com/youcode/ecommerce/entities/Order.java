package com.youcode.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends AuditEntities {

}
