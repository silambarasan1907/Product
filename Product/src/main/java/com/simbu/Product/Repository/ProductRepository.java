package com.simbu.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.simbu.Product.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByName(String name);

}
