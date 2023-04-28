package com.nacer.udemy01.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nacer.udemy01.entities.Product;
import com.nacer.udemy01.models.dtoRequests.ProductRequest;
import com.nacer.udemy01.repositories.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImp implements IProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		log.info("Getting product from DB with productId: "+id);
		Product productById=null;
		productById= repository.findById(id)
						 .orElseThrow(
								 ()->new RuntimeException("No product found with id= "+id));
		if(productById.equals(null))
			log.error("Exception: No product found with id= "+id);
		log.info("product with productId: {}, found with success",id);
		return productById;
	}

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		log.info("Getting All Products from DB");
		return repository.findAll();
	}

	@Override
	public Product add(ProductRequest request) {
		// TODO Auto-generated method stub
		log.info("Adding Product to DB..");
		Product product = Product.builder()
								.name(request.getName())
								.quantity(request.getQuantity())
								.price(request.getPrice())
								.build();
		product = repository.save(product);
		log.info("Product saved with success in DB");
		return product;
	}

	@Override
	public Product update(long productId, ProductRequest newValueProduct) {
		// TODO Auto-generated method stub
		log.info("Updating Product with id= "+productId);
		Product productToUpdate = null; 
		productToUpdate = repository.findById(productId)
				  		   .orElseThrow(
				  				()->new RuntimeException("No product found with id: "+productId));
		if(productToUpdate.equals(null))
			log.error("Exception: No product found with id= "+productId);
		BeanUtils.copyProperties(newValueProduct, productToUpdate);
		repository.save(productToUpdate);
		log.info("Product updated with success in DB");
		return productToUpdate;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		log.info("Deleating Product with id= {}", id);
		Product productToDelete = get(id);
		repository.delete(productToDelete);
		log.info("Product with id= {} deleated with success from DB", id);
	}

}
