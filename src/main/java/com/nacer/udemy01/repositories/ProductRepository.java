package com.nacer.udemy01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nacer.udemy01.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
