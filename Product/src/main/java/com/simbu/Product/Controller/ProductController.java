package com.simbu.Product.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simbu.Product.Model.Product;
import com.simbu.Product.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		
		return service.add(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.addMoreValue(products);
	}
	
	
	@GetMapping("/Product")
	public List<Product> findAll(){
		return service.listAll();
	}
	
	@GetMapping("/productById/{id}")
	public ResponseEntity<Product> findById(@PathVariable int id) {
		try {
			
		Product product =service.getById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/productByName/{name}")
	public Product findByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.delete(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.update(product);
	}

}
