package com.devsena.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsena.course.entities.Order;
import com.devsena.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	

	@GetMapping
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}
}
