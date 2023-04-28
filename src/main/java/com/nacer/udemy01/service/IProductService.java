package com.nacer.udemy01.service;

import java.util.List;

import com.nacer.udemy01.entities.Product;
import com.nacer.udemy01.models.dtoRequests.ProductRequest;

public interface IProductService {

	Product get(long id);
	List<Product> get();
	Product add(ProductRequest productRequest);
	Product update(long idOfProduct, ProductRequest productRequest);
	void delete(long id);
}
