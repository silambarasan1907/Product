package com.simbu.Product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simbu.Product.Model.Product;
import com.simbu.Product.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return repo.findAll();
	}
	
	public Product getById(int id) {
		return repo.findById(id).get();
	}
	
	public Product getByName(String name) {
		return repo.findByName(name);
	}
	
	public Product add(Product product) {
		return repo.save(product);
	}
	
	public List<Product> addMoreValue(List<Product> products){
		return repo.saveAll(products);
	}
	
	public Product update(Product product) {
		
		Product existingProduct =repo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct .setPrice(product.getPrice());
		return repo.save(existingProduct);
	}
	
	public String delete(int id) {
		repo.deleteById(id);
		return "Product removed id:"+id;
	}

}
