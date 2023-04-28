package com.nacer.udemy01.models.dtoResponces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Data @ToString
public class ProductResponce {

	private long id;
	private long price, name, quantity;
}
