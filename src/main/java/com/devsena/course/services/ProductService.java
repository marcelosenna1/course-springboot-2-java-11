package com.devsena.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsena.course.entities.Product;
import com.devsena.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	

	@GetMapping
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}
}
