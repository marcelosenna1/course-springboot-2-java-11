package com.devsena.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsena.course.entities.Category;
import com.devsena.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	

	@GetMapping
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}
}
