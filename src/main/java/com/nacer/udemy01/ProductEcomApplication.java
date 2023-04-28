package com.nacer.udemy01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductEcomApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductEcomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("product-Ecom microservice running.....");
	}

}
