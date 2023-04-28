package com.nacer.udemy01.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacer.udemy01.entities.Product;
import com.nacer.udemy01.models.dtoRequests.ProductRequest;
import com.nacer.udemy01.models.dtoResponces.ProductResponce;
import com.nacer.udemy01.service.IProductService;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

	@Autowired
	private IProductService service;
	
	private ProductResponce responce = new ProductResponce();
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.get();
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<ProductResponce> getProductById(@PathVariable long id) {
		BeanUtils.copyProperties(service.get(id),responce);
		return new ResponseEntity<>(responce,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ProductResponce> addProduct(@RequestBody ProductRequest request){
		BeanUtils.copyProperties(service.add(request),responce);
		return new ResponseEntity<>(responce,HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<ProductResponce> editProduct(
			@PathVariable long id,
			@RequestBody ProductRequest request)
	{
		BeanUtils.copyProperties(service.update(id,request),responce);
		return new ResponseEntity<>(responce,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id)
	{
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
