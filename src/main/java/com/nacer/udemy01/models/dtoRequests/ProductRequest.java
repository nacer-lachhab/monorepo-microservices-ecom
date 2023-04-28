package com.nacer.udemy01.models.dtoRequests;

import lombok.Data;

@Data
public class ProductRequest {

	private long price;
	private long quantity;
	private String name;
}
