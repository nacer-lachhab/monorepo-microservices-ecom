package com.nacer.udemy01.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder @Data
@Table(name = "PRODUCTS_TABLE")
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long id;
	
	@Column(name ="PRICE")
	private long price;
	
	@Column(name ="QUANTITY")	
	private long quantity;
	
	@Column(name = "PRODUCT_NAME")
	private String name;
}
